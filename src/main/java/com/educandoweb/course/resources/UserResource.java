package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.enitties.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
    @GetMapping
	public ResponseEntity<List<User>> findAll() { // método utilizado para retornar respostas de requisições web
    	List<User> list = service.findAll();	
       	
		return ResponseEntity.ok().body(list); // Resp.ent.ok retorna resposta no http e o body retorna o corpo da resposta
	}
	@GetMapping(value = "/{id}") // id será o objeto de busca
	public ResponseEntity<User> findById(@PathVariable Long id) { // path.variable é uma anotação que serve para reconhecer String 
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping // End point utilizado quando adicionado recurso ex = ADD usuario
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); // Para utilizar cód. 201 postman necessário usar o .created(URI) endereço de criação do cabeçalho
	}
	@DeleteMapping(value = "/{id}") // Anotação para deletar
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();// No.content quando é uma respota sem corpo
	}
	@PutMapping(value = "/{id}") // Put = Anotação para atualizar
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
