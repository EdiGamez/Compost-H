package com.composth.backend.Repository;

import com.composth.backend.entity.Registros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "registros", path = "registros")
public interface RegistrosRepository extends JpaRepository<Registros, Long> {
}
