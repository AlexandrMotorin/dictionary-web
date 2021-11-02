package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "numericDictionary")
public class NumericDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String translate;

    private int word;

    public NumericDictionary(String translate, int word) {
        this.translate = translate;
        this.word = word;
    }

    public NumericDictionary() {
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

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }
}
