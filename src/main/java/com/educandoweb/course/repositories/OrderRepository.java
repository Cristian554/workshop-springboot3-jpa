package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.enitties.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // A maneira de reutilização do JPA passando nome e tipod e chave
 
}
