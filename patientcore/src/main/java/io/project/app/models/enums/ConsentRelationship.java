package io.project.app.models.enums;

/**
 *
 * @author lilith
 */
public enum ConsentRelationship {

    brother("brother", "brother"),
    sister("sister", "sister"),
    mother("mother", "mother"),
    father("father", "father"),
    daughter("daughter", "daughter"),
    husband("husband", "husband");

    private final String key;
    private final String value;

    ConsentRelationship(String key, String value) {
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
