package com.jpataller.jpataller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpataller.jpataller.entities.Person;
import com.jpataller.jpataller.respositories.Personrepository;

@SpringBootApplication
public class JpatallerApplication implements CommandLineRunner{


	@Autowired
	private Personrepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpatallerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(person -> System.out.println(person));
		
	}

}
