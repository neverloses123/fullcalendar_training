package com.example.model;

import jakarta.persistence.*;

/**
 * @author 2400048
 */
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_tel")
    private String memberTel;
    @Column(name = "member_apartment")
    private String memberApartment;
    @Column(name = "member_mail")
    private String memberMail;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberTel() {
        return memberTel;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    public String getMemberApartment() {
        return memberApartment;
    }

    public void setMemberApartment(String memberApartment) {
        this.memberApartment = memberApartment;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }
}
