package com.example.repository;

import com.example.model.Member;
import com.example.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 2400048
 */
public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustomized {
    List<Project> findByProjectName(String projectName);
}
