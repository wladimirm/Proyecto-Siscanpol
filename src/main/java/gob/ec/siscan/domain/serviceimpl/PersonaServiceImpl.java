package gob.ec.siscan.domain.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gob.ec.siscan.commons.GenericServiceImpl;
import gob.ec.siscan.domain.model.Persona;
import gob.ec.siscan.domain.service.PersonaServicio;
import gob.ec.siscan.model.domain.repositoryjpa.PersonaRepositoryJPA;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements PersonaServicio{

	@Autowired
	private PersonaRepositoryJPA personarepositoryjp;
	
	@Override
	public CrudRepository<Persona, Long> getrepositorycrud() {
		// TODO Auto-generated method stub
		return personarepositoryjp;
	}
	

}
