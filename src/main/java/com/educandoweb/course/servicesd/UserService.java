package com.educandoweb.course.servicesd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.enitties.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // Anotation utilizado para registrar serviços
public class UserService {
	
    @Autowired
	private UserRepository repository;// Gerando dependecia UserRepository
    
    public List<User> findAll(){ // camada de serviços
		return repository.findAll();
    	
    }
    
  public User findById(Long Id) {
	Optional<User> obj = repository.findById(Id);
	  return obj.get();
  }
  
  public User insert(User obj) { // Salva o usuário
	  return repository.save(obj);
  }
  public void delete(Long id) {
	  repository.deleteById(id);
  }
  
}
