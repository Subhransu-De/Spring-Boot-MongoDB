package com.example.springbootapplication.repository;

import com.example.springbootapplication.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
