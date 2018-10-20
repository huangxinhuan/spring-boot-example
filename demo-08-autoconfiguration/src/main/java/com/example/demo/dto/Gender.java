package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Gender implements Serializable {
    MALE("M"), FEMALE("F"), UNKNOWN("U");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender build(String val) {
        switch (val) {
            case "M":
                return MALE;
            case "F":
                return FEMALE;
            default:
                return UNKNOWN;
        }
    }


    @JsonValue
    @Override
    public String toString() {
        return value;
    }
}
