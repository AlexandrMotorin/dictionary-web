package com.example.demo.services;

import com.example.demo.entities.EnglishDictionary;
import com.example.demo.entities.NumericDictionary;

import java.util.List;

public interface DictionaryService {
    List<EnglishDictionary> getAllEnglishEntries();
    List<NumericDictionary> getAllNumericEntries();

    EnglishDictionary addNewEnEntry(EnglishDictionary englishDictionary);
    NumericDictionary addNewNumEntry(NumericDictionary numericDictionary);

    EnglishDictionary updateEnEntry(String id, EnglishDictionary englishDictionary);
    NumericDictionary updateNumEntry(String id, NumericDictionary numericDictionary);

    EnglishDictionary getEnById(String id);
    NumericDictionary getNumById(String id);

    void deleteEnglishEntry(String id);
    void deleteNumericEntry(String id);
}
