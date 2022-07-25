package com.portfolio.backend.repository;

import com.portfolio.backend.models.Townships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownshipRepository extends JpaRepository<Townships, Long> {
}
