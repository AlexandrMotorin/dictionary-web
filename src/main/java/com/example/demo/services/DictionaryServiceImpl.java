package com.example.demo.services;

import com.example.demo.entities.EnglishDictionary;
import com.example.demo.entities.NumericDictionary;
import com.example.demo.exceptions.NoSuchEntryException;
import com.example.demo.exceptions.NoValidException;
import com.example.demo.repository.EnglishDictionaryRepository;
import com.example.demo.repository.NumericDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private EnglishDictionaryRepository englishDictionaryRepository;

    @Autowired
    private NumericDictionaryRepository numericDictionaryRepository;

    @Override
    public List<EnglishDictionary> getAllEnglishEntries(){
        List<EnglishDictionary> result = new ArrayList<>(englishDictionaryRepository.findAll());
        result.sort(Comparator.comparing(EnglishDictionary::getWord));
        return result;
    }

    @Override
    public List<NumericDictionary> getAllNumericEntries(){
        List<NumericDictionary> result = new ArrayList<>(numericDictionaryRepository.findAll());
        result.sort(Comparator.comparing(NumericDictionary::getWord));
        return result;
    }

    @Override
    public EnglishDictionary addNewEnEntry(EnglishDictionary englishDictionary) {
        if(!enDictValid(englishDictionary)) throw new NoValidException("Введены некорректные значения");
        englishDictionaryRepository.save(englishDictionary);
        return englishDictionary;
    }

    @Override
    public NumericDictionary addNewNumEntry(NumericDictionary numericDictionary) {
        if(!numDictValid(numericDictionary)) throw new NoValidException("Введены некорректные значения");
        numericDictionaryRepository.save(numericDictionary);
        return numericDictionary;
    }

    @Override
    public EnglishDictionary updateEnEntry(String id, EnglishDictionary englishDictionary) {
        EnglishDictionary source = getEnById(id);

        if(!enDictValid(englishDictionary)) throw new NoValidException("Введены некорректные значения");

        source.setTranslate(englishDictionary.getTranslate());
        source.setWord(englishDictionary.getWord());

        englishDictionaryRepository.save(source);
        return source;
    }

    @Override
    public NumericDictionary updateNumEntry(String id, NumericDictionary numericDictionary) {
        NumericDictionary source = getNumById(id);

        if(!numDictValid(numericDictionary)) throw new NoValidException("Введены некорректные значения");

        source.setTranslate(numericDictionary.getTranslate());
        source.setWord(numericDictionary.getWord());

        numericDictionaryRepository.save(source);
        return source;
    }

    @Override
    public EnglishDictionary getEnById(String id) {
        int enId = idValid(id);
        return englishDictionaryRepository.findById(enId)
                .orElseThrow(() -> new NoSuchEntryException("Такой записи нет в словаре"));
    }

    @Override
    public NumericDictionary getNumById(String id) {
        int numId = idValid(id);
        return numericDictionaryRepository.getById(numId);
    }

    @Override
    public void deleteEnglishEntry(String id) {
        int enId = idValid(id);
        englishDictionaryRepository.deleteById(enId);
    }

    @Override
    public void deleteNumericEntry(String id) {
        int numId = idValid(id);
        numericDictionaryRepository.getById(numId);
    }

    public boolean enDictValid(EnglishDictionary englishDictionary){

        if(englishDictionary.getTranslate() == null || englishDictionary.getWord() == null) return false;

        String translate = englishDictionary.getTranslate();
        String word = englishDictionary.getWord();


        return translate.toLowerCase().matches("[а-я]+") && word.toLowerCase().matches("[a-z]{4}");
    }

    public boolean numDictValid(NumericDictionary numericDictionary){

        if(numericDictionary.getTranslate() == null) return false;

        String translate = numericDictionary.getTranslate();
        String word = String.valueOf(numericDictionary.getWord());

        return translate.toLowerCase().matches("[а-я]+") && word.matches("\\d{5}");
    }

    private int idValid(String id){
        if(!id.matches("\\d+")) throw new NoValidException("Некорректный id");
        return Integer.parseInt(id);
    }
}
