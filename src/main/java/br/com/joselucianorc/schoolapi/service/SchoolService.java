package br.com.joselucianorc.schoolapi.service;

import java.util.List;

import br.com.joselucianorc.schoolapi.model.entity.School;

public interface SchoolService {
	
	List<School> findAll();
	
	School create(School school);
	
	School getById(Long id);
	
	School update(School school, Long id);
	
	void delete(Long id);

}
