package com.educandoweb.course.servicesd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.enitties.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service // Anotation utilizado para registrar serviços
public class ProductService {
	
    @Autowired
	private ProductRepository repository;// Gerando dependecia ProductRepository
    
    public List<Product> findAll(){ // camada de serviços
		return repository.findAll();
    	
    }
    
  public Product findById(Long Id) {
	Optional<Product> obj = repository.findById(Id);
	  return obj.get();
  }
  
}
