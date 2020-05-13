/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patient.submodels;

/**
 *
 * @author lilith
 */
public class HumanName {
//     // from Element: extension
//  "use" : "<code>", // usual | official | temp | nickname | anonymous | old | maiden
//  "text" : "<string>", // Text representation of the full name
//  "family" : "<string>", // Family name (often called 'Surname')
//  "given" : ["<string>"], // Given names (not always 'first'). Includes middle names
//  "prefix" : ["<string>"], // Parts that come before the name
//  "suffix" : ["<string>"], // Parts that come after the name
//  "period" : { Period } // Time period when name was/is in use
    
    public enum use { usual, official, temp, nickname, anonymous, old, maiden}; 
    
    private String text;
    
    private String family;
    
    private String given[];
    
    private String prefix[];
    
    private String suffix[];
    
    Period period = new Period();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String[] getGiven() {
        return given;
    }

    public void setGiven(String[] given) {
        this.given = given;
    }

    public String[] getPrefix() {
        return prefix;
    }

    public void setPrefix(String[] prefix) {
        this.prefix = prefix;
    }

    public String[] getSuffix() {
        return suffix;
    }

    public void setSuffix(String[] suffix) {
        this.suffix = suffix;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    
    
    
}
