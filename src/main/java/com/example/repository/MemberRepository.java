package com.example.repository;

import com.example.model.Customer;
import com.example.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 2400048
 */
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustomized {
    List<Member> findByMemberName(String memberName);
}
