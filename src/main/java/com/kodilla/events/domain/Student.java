package com.kodilla.events.domain;

import org.apache.commons.lang3.RandomStringUtils;

public class Student {
    private String indexNumber;

    public Student(int z) {
        this.indexNumber = RandomStringUtils.randomAlphabetic(z);
    }
}
