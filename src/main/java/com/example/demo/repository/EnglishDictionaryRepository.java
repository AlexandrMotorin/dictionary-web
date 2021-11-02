package com.example.demo.repository;

import com.example.demo.entities.EnglishDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnglishDictionaryRepository extends JpaRepository<EnglishDictionary,Integer> {
}
