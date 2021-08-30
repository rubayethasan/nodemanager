package com.rubayet.nodemanager.repository;

import com.rubayet.nodemanager.model.ApiNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiNodeRepository extends JpaRepository<ApiNode, Long> {
}
