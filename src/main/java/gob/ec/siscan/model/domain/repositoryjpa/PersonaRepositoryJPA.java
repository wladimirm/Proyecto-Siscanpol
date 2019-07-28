package gob.ec.siscan.model.domain.repositoryjpa;

import org.springframework.data.repository.CrudRepository;

import gob.ec.siscan.domain.model.Persona;

public interface PersonaRepositoryJPA extends CrudRepository<Persona, Long> {

}
