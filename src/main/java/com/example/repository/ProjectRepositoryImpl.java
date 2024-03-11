package com.example.repository;

import com.example.model.Member;
import com.example.model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

/**
 * @author 2400048
 */
public class ProjectRepositoryImpl implements ProjectRepositoryCustomized {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Project> findAllDetail(Project project) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "select a.*,b.member,c.customer from project " +
                        "a left join member b on b.id=a.member_id" +
                        "left join customer c on c.id=a.customer_id where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Project> result =query.getResultList();
        return result;
    }
}
