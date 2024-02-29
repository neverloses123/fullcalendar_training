package com.example.repository;

import com.example.model.Member;
import com.example.model.Project;

import java.util.List;

public interface ProjectRepositoryCustomized {
    List<Project> findAllDetail(Project project);
}
