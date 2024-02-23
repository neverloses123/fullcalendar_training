package com.example.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class Utils {
	public static String[] colorMap = new String[]
	{"#B71C1C", "#880E4F", "#1A237E", "#01579B", "#004D40", "#1B5E20", "#006064", "#0D47A1", "#4A148C", "#311B92",
	 "#33691E", "#827717", "#F57F17", "#E65100", "#BF360C", "#3E2723", "#212121", "#263238", "#EF5350", "#FF6F00",
	 "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5", "#26C6DA", "#66BB6A", "#FFB74D", "#BCAAA4", "#29B6F6"
	};
	
	private Utils() {}

	public static String convertJavaDateToSimpleDateString(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date=sdf.parse(dateStr);
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf2.format(date);
	}
	
	public static String convertJavaDateToDateStr(Date date) throws ParseException{		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf2.format(date);
	}
	
	public static String convertJavaDateToDateNoTimeStr(Date date) throws ParseException{		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		return sdf2.format(date);
	}
	
	
	public static String encodePassword(String password) {
		return DigestUtils.md5Hex(password);
	}
	
	public static boolean matchPassword(String rawPassword, String encodedPassword) {
		String encryptPwd=encodePassword(rawPassword);
		if(encryptPwd.equals(encodedPassword)) return true;
		else return false;
	}
	
	public static HttpSession session(boolean create) {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request=attr.getRequest();
	    
	    HttpSession session = request.getSession(create);
	    return session; // true == allow create
	}
	
	public static HttpServletRequest request() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request=attr.getRequest();
	    return request;
	}
	
}
