package com.jpaandspring.jpa.repositories;


import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpaandspring.jpa.entities.Person;

public interface Personrepository extends CrudRepository<Person, Long>{

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName (String programmingLanguage, String name );

    Optional<Person> findByNameContaining(String name);


    @Query("select p from Person p where p.programmingLanguage=?1 and p.name =?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    // Consulta para encontrar una persona por su ID
    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Optional<Person> findOneById(Long id);

    // Consulta para encontrar una persona por su nombre exacto
    @Query("SELECT p FROM Person p WHERE p.name = ?1")
    Optional<Person> findOneByName(String name);

    // Consulta para encontrar una persona cuyo nombre contenga el texto proporcionado
    @Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
    Optional<Person> findOneByNameContaining(String name);

    

    



    

}