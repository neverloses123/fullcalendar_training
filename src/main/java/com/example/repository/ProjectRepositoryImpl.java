package com.example.repository;

import com.example.model.Member;
import com.example.model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepositoryCustomized {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Project> findAllDetail(Project project) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "select * from project where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Project> result =query.getResultList();
        return result;
    }
}
