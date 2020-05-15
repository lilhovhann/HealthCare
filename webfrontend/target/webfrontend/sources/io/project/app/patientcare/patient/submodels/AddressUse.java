/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.patient.submodels;

/**
 *
 * @author lilith
 */
public enum AddressUse {

        home("home","home"), 
        work("work", "work"), 
        temp("temp","temp"), 
        old("old","old"), 
        billing("billing","billing");
        
        private final String key;
        private final String value;

    private AddressUse(String key, String value) {
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
