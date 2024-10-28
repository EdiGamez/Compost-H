package com.composth.backend.Repository;

import com.composth.backend.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "partida", path = "partida")
public interface PartidaRepository extends JpaRepository<Partida, String> {
}
