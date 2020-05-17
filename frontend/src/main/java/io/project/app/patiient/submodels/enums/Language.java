package io.project.app.patiient.submodels.enums;

import java.io.Serializable;

/**
 *
 * @author lilith
 */
public enum Language implements Serializable{
    
        armenian("armenian","armenian"), 
        russian("russian", "russian"), 
        english("english","english");
        
        
        private final String key;
        private final String value;

    Language(String key, String value) {
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
