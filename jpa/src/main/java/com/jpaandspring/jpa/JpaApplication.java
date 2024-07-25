package com.jpaandspring.jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpaandspring.jpa.entities.Person;
import com.jpaandspring.jpa.repositories.Personrepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	@Autowired
	private Personrepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List<Person> persons = (List<Person>) personRepository.findAll();
		// persons.stream().forEach(person -> System.out.println(person));

		List<Object[]> persons =  personRepository.obtenerPersonData();
		persons.stream().forEach(person -> System.out.println(person));
		create();
	}	

	@Transactional // Basicamente jpa le dice a spring que cancele toda la operacion si algo sale mal
	public void create(){ 


		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el nombre: ");
		String name = scanner.next();

		System.out.println("Ingrese el apellido: ");
		String lastName = scanner.next();

		System.out.println("Ingrese el lenguaje de programación: ");
		String programmingLanguage = scanner.next();

		scanner.close();

		Person person = new Person(null, name, lastName, programmingLanguage);

		// confirma guardado
		Person personNew = personRepository.save(person);
		System.out.println(personNew);

		personRepository.findById(personNew.getId()).ifPresent(System.out::println);
		


	}

}
