package br.com.joselucianorc.schoolapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;
import br.com.joselucianorc.schoolapi.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	private SchoolRepository repository;
	
	public SchoolServiceImpl(SchoolRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<School> findAll() {
		return repository.findAll();
	}

	@Override
	public School create(School school) {
		return this.repository.save(school);
	}

	@Override
	public School getById(Long id) {
		return this.repository.getById(id);
	}

	@Override
	public School update(School school, Long id) {		
		Optional<School> foundSchool = this.repository.findById(id);
		
		if (foundSchool.isPresent()) {
			School updateSchool = foundSchool.get();
			updateSchool.setName(school.getName());
			updateSchool.setEmail(school.getEmail());							
			return this.repository.save(updateSchool);
		} else {
			school.setId(id);
			return this.repository.save(school);
		}		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
