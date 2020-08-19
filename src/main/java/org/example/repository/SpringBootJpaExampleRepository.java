package org.example.repository;

import org.example.po.SpringBootJpaExamplePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringBootJpaExampleRepository extends JpaRepository<SpringBootJpaExamplePO, Long>, JpaSpecificationExecutor<SpringBootJpaExamplePO> {
}
