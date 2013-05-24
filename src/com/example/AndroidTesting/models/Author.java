package com.example.AndroidTesting.models;


public class Author {

    private static int idGen = 0;
    private int id;
    public String name;

    public Author(String name) {
        this.id = idGen++;
        this.name = name;
    }
}
