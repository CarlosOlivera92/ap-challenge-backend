package com.portfolio.backend.repository;

import com.portfolio.backend.models.ProjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<ProjectsModel, Long> {
}
