package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.enitties.User;

public interface UserRepository extends JpaRepository<User, Long> { // A maneira de reutilização do JPA passando nome e tipod e chave
 
}
