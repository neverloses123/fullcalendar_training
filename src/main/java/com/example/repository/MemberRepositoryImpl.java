package com.example.repository;

import com.example.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

/**
 * @author 2400048
 */
public class MemberRepositoryImpl implements MemberRepositoryCustomized{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> findAllDetail(Member member) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "select * from member where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Member> result =query.getResultList();

        return result;
    }
}
