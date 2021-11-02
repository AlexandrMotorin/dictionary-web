package com.example.demo.repository;

import com.example.demo.entities.NumericDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumericDictionaryRepository extends JpaRepository<NumericDictionary,Integer> {
}
