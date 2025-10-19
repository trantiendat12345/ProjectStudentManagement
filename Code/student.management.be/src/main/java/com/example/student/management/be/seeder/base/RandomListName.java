package com.example.student.management.be.seeder.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomListName {
    
    public List<String> listName (int sum) {
        Faker faker = new Faker(Locale.forLanguageTag("vi-VN"));
        List<String> listName = new ArrayList<>();
        for (int i = 0; i <= sum; i++) {
            String fullName = faker.name().fullName();
            listName.add(fullName);
        }
        return listName;
    }
    
}
