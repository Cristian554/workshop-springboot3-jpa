package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.enitties.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // Anotation utilizado para registrar serviços
public class UserService {

	@Autowired
	private UserRepository repository;// Gerando dependecia UserRepository

	public List<User> findAll() { // camada de serviços
		return repository.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) { // Salva o usuário
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (!repository.existsById(id))
				throw new ResourceNotFoundException(id);
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());

		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id); // getRefe = deixa monitorado com JPA para depois enviar para
															// o
			// banco de dados
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {			
		} throw new ResourceNotFoundException(id);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
