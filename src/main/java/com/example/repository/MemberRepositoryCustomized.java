package com.example.repository;

import com.example.model.Member;

import java.util.List;

/**
 * @author 2400048
 */
public interface MemberRepositoryCustomized {
    List<Member> findAllDetail(Member member);
}
