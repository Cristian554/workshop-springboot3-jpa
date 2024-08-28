package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.enitties.Product;
import com.educandoweb.course.servicesd.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
    @GetMapping
	public ResponseEntity<List<Product>> findAll() { // método utilizado para retornar respostas de requisições web
    	List<Product> list = service.findAll();	
       	
		return ResponseEntity.ok().body(list); // Resp.ent.ok retorna resposta no http e o body retorna o corpo da resposta
	}
	@GetMapping(value = "/{id}") // id será o objeto de busca
	public ResponseEntity<Product> findById(@PathVariable Long id) { // path.variable é uma anotação que serve para reconhecer String 
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
