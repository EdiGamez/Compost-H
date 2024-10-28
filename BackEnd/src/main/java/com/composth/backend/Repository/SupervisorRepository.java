package com.composth.backend.Repository;

import com.composth.backend.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "supervisor", path = "supervisor")
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
