package com.example.repository;

import com.example.model.Member;

import java.util.List;

public interface MemberRepositoryCustomized {
    List<Member> findAllDetail(Member member);
}
