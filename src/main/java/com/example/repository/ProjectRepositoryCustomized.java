package com.example.repository;

import com.example.model.Member;
import com.example.model.Project;

import java.util.List;

/**
 * @author 2400048
 */
public interface ProjectRepositoryCustomized {
    List<Project> findAllDetail(Project project);
}
