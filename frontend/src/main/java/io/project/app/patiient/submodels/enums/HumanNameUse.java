/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patiient.submodels.enums;

import java.io.Serializable;

/**
 *
 * @author lilith
 */
public enum HumanNameUse {
    
        usual("usual","usual"), 
        official("official", "official"), 
        temp("temp","temp"), 
        nickname("nickname","nickname"), 
        anonymous("anonymous","anonymous"), 
        old("old","old"), 
        maiden("maiden","maiden");
        
        private final String key;
        private final String value;

    HumanNameUse(String key, String value) {
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
