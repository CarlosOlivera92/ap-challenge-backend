package com.portfolio.backend.repository;

import com.portfolio.backend.models.States;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<States, Long> {
}
