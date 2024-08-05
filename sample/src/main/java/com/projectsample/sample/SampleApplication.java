package com.projectsample.sample;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projectsample.sample.domain.entity.Account;
import com.projectsample.sample.domain.entity.Role;
import com.projectsample.sample.domain.entity.RoleEnum;
import com.projectsample.sample.domain.repository.AccountRepository;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);

		
	}

	@Autowired
	PasswordEncoder encoder;

	@Autowired 
	AccountRepository accountRepository;

	

	@Bean
	CommandLineRunner init(){

		return args -> {

			Role role = new Role();
			role.setName(
				RoleEnum.ADMIN
			);	
			Account testAccount = new Account();
			testAccount.setEmail("sample@gmail.com");
			testAccount.setPassword(encoder.encode("1234"));
			testAccount.setRoles(Set.of(role));
			// Obtener el conjunto de roles
			Set<Role> roles = testAccount.getRoles();

			System.out.println("HHHHHHHHHHHEYYYYYYYYYYYYYY ----> ");
			// Imprimir cada rol
			for (Role rolet : roles) {
				System.out.println("Role: " + rolet.getName()); // Asumiendo que `getName()` devuelve el nombre del rol
}
			
			
			accountRepository.save(testAccount);


			Role role2 = new Role();
			role2.setName(
				RoleEnum.USER
			);	
			Account testAccount2 = new Account();
			testAccount2.setEmail("sample2@gmail.com");
			testAccount2.setPassword(encoder.encode("12345"));
			testAccount2.setRoles(Set.of(role2));
	
			accountRepository.save(testAccount2);
		};
	}

	

}
