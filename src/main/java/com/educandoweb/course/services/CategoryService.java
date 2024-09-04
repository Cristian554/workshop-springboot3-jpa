package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.enitties.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service // Anotation utilizado para registrar serviços
public class CategoryService {
	
    @Autowired
	private CategoryRepository repository;// Gerando dependecia CategoryRepository
    
    public List<Category> findAll(){ // camada de serviços
		return repository.findAll();
    	
    }
    
  public Category findById(Long Id) {
	Optional<Category> obj = repository.findById(Id);
	  return obj.get();
  }
  
}
