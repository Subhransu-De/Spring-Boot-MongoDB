package com.example.SpringLearnMongoDB.Vacancy;

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
public class VacancyController {

  private final VacancyService vacancyService;

  @Autowired
  public VacancyController(VacancyService vacancyService) {
    this.vacancyService = vacancyService;
  }

  @GetMapping
  public List<Vacancy> getVacancies() {
    return vacancyService.getVacancies();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Vacancy> getVacancyById(@PathVariable("id") String vacancy_id) {
    return vacancyService.getVacancyById(vacancy_id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy requestBody) {
    return vacancyService.createVacancy(requestBody);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Vacancy> updateVacancy(@PathVariable("id") String vacancy_id,
      @RequestBody Vacancy requestBody) {
    return vacancyService.updateVacancy(vacancy_id, requestBody);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<HttpStatus> deleteVacancy(@PathVariable("id") String vacancy_id) {
    return vacancyService.deleteVacancy(vacancy_id);
  }

}