package com.example.demo.controllers;

import com.example.demo.entities.NumericDictionary;
import com.example.demo.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict/num")
public class NumericDictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("")
    public List<NumericDictionary> getAllNumericEntries(){
        return dictionaryService.getAllNumericEntries();
    }

    @GetMapping("/{id}")
    public NumericDictionary getNumEntryById(@PathVariable String id){
        return dictionaryService.getNumById(id);
    }

    @PostMapping("")
    public NumericDictionary addNewNumEntry(@RequestBody NumericDictionary numericDictionary){
        return dictionaryService.addNewNumEntry(numericDictionary);
    }

    @PutMapping("/{id}")
    public NumericDictionary updateNumEntry(@PathVariable String id, @RequestBody NumericDictionary numericDictionary){
        return dictionaryService.updateNumEntry(id,numericDictionary);
    }

    @DeleteMapping("/{id}")
    public void deleteNumEntry(@PathVariable String id){
        dictionaryService.deleteNumericEntry(id);
    }


}
