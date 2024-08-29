package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.enitties.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { // A maneira de reutilização do JPA passando nome e tipod e chave
 
}
