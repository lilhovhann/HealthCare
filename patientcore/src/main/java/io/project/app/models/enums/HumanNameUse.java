package io.project.app.models.enums;
/**
 *
 * @author lilith
 */
public enum HumanNameUse {

   
    official("official", "official"),
    anonymous("anonymous", "anonymous");
    

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
