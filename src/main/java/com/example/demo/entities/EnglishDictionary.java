package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "englishDictionary")
public class EnglishDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String translate;

    private String word;

    public EnglishDictionary(String translate, String word) {
        this.translate = translate;
        this.word = word;
    }

    public EnglishDictionary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
