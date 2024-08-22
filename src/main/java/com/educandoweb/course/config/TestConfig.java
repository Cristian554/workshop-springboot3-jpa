package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.enitties.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // anotação especifico para teste
@Profile("test")// nome igual que esta no applic.prop
public class TestConfig implements CommandLineRunner{ // comandLine executa depencia sempre que o programa for iniciado

	@Autowired // notação utilizada para gerar dependencia do User com TestConfig
	private UserRepository userRepository;

@Override
public void run(String... args) throws Exception { // tudo colocado nesse método quando começar a aplicação será iniciado
	
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	userRepository.saveAll(Arrays.asList(u1, u2)); // SaveAll, salva no banco de dados
}
}
