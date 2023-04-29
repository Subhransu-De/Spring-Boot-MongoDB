package com.example.springbootapplication.service;

import com.example.springbootapplication.domain.Person;
import com.example.springbootapplication.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository vacancyRepository;

  @Autowired
  public PersonService(PersonRepository VacancyRepository) {
    this.vacancyRepository = VacancyRepository;
  }

  public List<Person> getVacancies() {
    return vacancyRepository.findAll();
  }

  public ResponseEntity<Person> getVacancyById(String vacancy_id) {
    Optional<Person> oneVacancy = vacancyRepository.findById(vacancy_id);
    if (oneVacancy.isPresent()) {
      return new ResponseEntity<>(oneVacancy.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Person> updateVacancy(String vacancy_id, Person person) {
    Optional<Person> oneVacancy = vacancyRepository.findById(vacancy_id);
    if (oneVacancy.isPresent()) {
      Person newPerson = oneVacancy.get();
      newPerson.setName(person.getName());
      System.out.println(person.getvacancy_description());
      return new ResponseEntity<>(vacancyRepository.save(newPerson), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Person> createVacancy(Person requestBody) {
    try {
      Person newPerson = vacancyRepository.save(
          new Person(
              requestBody.getName(),
              requestBody.getvacancy_description()));
      return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<HttpStatus> deleteVacancy(String vacancy_id) {
    try {
      vacancyRepository.deleteById(vacancy_id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
