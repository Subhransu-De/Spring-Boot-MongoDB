package com.example.springbootapplication.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vacancy")
public class Person {

  @Id
  public String id;

  public String name;
  public String summary;

  public Person() {
  }

  public Person(String id, String name, String summary) {
    this.id = id;
    this.name = name;
    this.summary = summary;
  }

  public Person(String name, String summary) {
    this.name = name;
    this.summary = summary;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getvacancy_description() {
    return summary;
  }

  public void setvacancy_description(String vacancy_description) {
    this.summary = vacancy_description;
  }
}
