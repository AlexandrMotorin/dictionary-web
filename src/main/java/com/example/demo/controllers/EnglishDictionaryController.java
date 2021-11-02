package com.example.demo.controllers;

import com.example.demo.entities.EnglishDictionary;
import com.example.demo.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dict/en")
public class EnglishDictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("")
    public List<EnglishDictionary> getAllEnglishEntries(){
        return dictionaryService.getAllEnglishEntries();
    }

    @GetMapping("{id}")
    public EnglishDictionary getEnEntryById(@PathVariable String id){
        return dictionaryService.getEnById(id);
    }


    @PostMapping("")
    public EnglishDictionary addNewEnEntry(@RequestBody EnglishDictionary englishDictionary){
        return dictionaryService.addNewEnEntry(englishDictionary);
    }


    @PutMapping( "/{id}")
    public EnglishDictionary updateEnEntry(@PathVariable String id, @RequestBody EnglishDictionary englishDictionary){
        return dictionaryService.updateEnEntry(id,englishDictionary);
    }

    @DeleteMapping( "/{id}")
    public void deleteEnEntry(@PathVariable String id){
        dictionaryService.deleteEnglishEntry(id);
    }
}
