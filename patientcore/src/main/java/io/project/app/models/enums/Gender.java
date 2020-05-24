/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.models.enums;


/**
 *
 * @author lilith
 */
public enum Gender {

    male("male", "male"),
    female("female", "female"),
    other("other", "other"),
    unknown("unknown", "unknown");

    private final String key;
    private final String value;

    Gender(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
