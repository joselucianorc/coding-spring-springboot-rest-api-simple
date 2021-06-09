package br.com.joselucianorc.schoolapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.service.SchoolService;

@RestController
@RequestMapping("v1/schools")
public class SchoolController {

	private SchoolService service;
	
	private SchoolController(SchoolService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public List<School> findAll() {
		return service.findAll();
	}

	@PostMapping("/")
	@ResponseBody
	public School createNew(@RequestBody School school) {
		return service.create(school);
	}
	
	@GetMapping("/{id}")
	public School getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PutMapping("/{id}")
	public School update(@RequestBody School school, Long id) {
		return service.update(school, id);		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}