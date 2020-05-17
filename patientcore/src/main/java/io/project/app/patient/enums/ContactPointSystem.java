/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patient.enums;

import java.io.Serializable;

/**
 *
 * @author lilith
 */
public enum ContactPointSystem  {

    phone("phone", "phone"),
    email("email", "email"),
    other("other", "other");

    private final String key;
    private final String value;

    ContactPointSystem(String key, String value) {
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
