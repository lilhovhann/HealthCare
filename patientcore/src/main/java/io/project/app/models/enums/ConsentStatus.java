package io.project.app.models.enums;

/**
 *
 * @author lilith
 */
public enum ConsentStatus {

    active("active", "active"),
    inactive("inactive", "inactive");

    private final String key;
    private final String value;

    ConsentStatus(String key, String value) {
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
