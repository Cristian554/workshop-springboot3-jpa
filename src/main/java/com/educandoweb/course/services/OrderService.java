package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.enitties.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service // Anotation utilizado para registrar serviços
public class OrderService {

	@Autowired
	private OrderRepository repository;// Gerando dependecia OrderRepository

	public List<Order> findAll() { // camada de serviços
		return repository.findAll();

	}

	public Order findById(Long Id) {
		Optional<Order> obj = repository.findById(Id);
		return obj.get();
	}

}
