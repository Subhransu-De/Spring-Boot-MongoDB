package com.example.springbootapplication.controller;

import com.example.springbootapplication.domain.Person;
import com.example.springbootapplication.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vacancies")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public List<Person> getVacancies() {
    return personService.getVacancies();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Person> getVacancyById(@PathVariable("id") String vacancy_id) {
    return personService.getVacancyById(vacancy_id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> createVacancy(@RequestBody Person requestBody) {
    return personService.createVacancy(requestBody);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> updateVacancy(@PathVariable("id") String vacancy_id,
                                              @RequestBody Person requestBody) {
    return personService.updateVacancy(vacancy_id, requestBody);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<HttpStatus> deleteVacancy(@PathVariable("id") String vacancy_id) {
    return personService.deleteVacancy(vacancy_id);
  }

}