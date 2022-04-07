package com.example.SpringLearnMongoDB.Vacancy;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {

  private final VacancyRepository vacancyRepository;

  @Autowired
  public VacancyService(VacancyRepository VacancyRepository) {
    this.vacancyRepository = VacancyRepository;
  }

  public List<Vacancy> getVacancies() {
    return vacancyRepository.findAll();
  }

  public ResponseEntity<Vacancy> getVacancyById(String vacancy_id) {
    Optional<Vacancy> oneVacancy = vacancyRepository.findById(vacancy_id);
    if (oneVacancy.isPresent()) {
      return new ResponseEntity<>(oneVacancy.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Vacancy> updateVacancy(String vacancy_id, Vacancy vacancy) {
    Optional<Vacancy> oneVacancy = vacancyRepository.findById(vacancy_id);
    if (oneVacancy.isPresent()) {
      Vacancy newVacancy = oneVacancy.get();
      newVacancy.setVacancy_title(vacancy.getVacancy_title());
      System.out.println(vacancy.getvacancy_description());
      return new ResponseEntity<>(vacancyRepository.save(newVacancy), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Vacancy> createVacancy(Vacancy requestBody) {
    try {
      Vacancy newVacancy = vacancyRepository.save(
          new Vacancy(
              requestBody.getVacancy_title(),
              requestBody.getvacancy_description()));
      return new ResponseEntity<>(newVacancy, HttpStatus.CREATED);
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
