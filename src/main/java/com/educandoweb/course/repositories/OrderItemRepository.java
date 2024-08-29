package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.enitties.OrderItem;
import com.educandoweb.course.enitties.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> { // A maneira de reutilização do JPA passando nome e tipod e chave
 
}
