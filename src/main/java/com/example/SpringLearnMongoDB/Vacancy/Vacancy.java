package com.example.SpringLearnMongoDB.Vacancy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vacancy")
public class Vacancy {

  @Id
  public String vacancy_id;

  public String vacancy_title;
  public String vacancy_description;

  public Vacancy() {
  }

  public Vacancy(String vacancy_id, String vacancy_title, String vacancy_description) {
    this.vacancy_id = vacancy_id;
    this.vacancy_title = vacancy_title;
    this.vacancy_description = vacancy_description;
  }

  public Vacancy(String vacancy_title, String vacancy_description) {
    this.vacancy_title=vacancy_title;
    this.vacancy_description=vacancy_description;
  }

  public String getVacancy_id() {
    return vacancy_id;
  }

  public void setVacancy_id(String vacancy_id) {
    this.vacancy_id = vacancy_id;
  }

  public String getVacancy_title() {
    return vacancy_title;
  }

  public void setVacancy_title(String vacancy_title) {
    this.vacancy_title = vacancy_title;
  }

  public String getvacancy_description() {
    return vacancy_description;
  }

  public void setvacancy_description(String vacancy_description) {
    this.vacancy_description = vacancy_description;
  }
}
