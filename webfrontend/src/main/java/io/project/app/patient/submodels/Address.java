
package io.project.app.patient.submodels;

/**
 *
 * @author lilith
 */
public class Address {
//     // from Element: extension
//  "use" : "<code>", // home | work | temp | old | billing - purpose of this address
//  "type" : "<code>", // postal | physical | both
//  "text" : "<string>", // Text representation of the address
//  "line" : ["<string>"], // Street name, number, direction & P.O. Box etc.
//  "city" : "<string>", // Name of city, town etc.
//  "district" : "<string>", // District name (aka county)
//  "state" : "<string>", // Sub-unit of country (abbreviations ok)
//  "postalCode" : "<string>", // Postal code for area
//  "country" : "<string>", // Country (e.g. can be ISO 3166 2 or 3 letter code)
//  "period" : { Period } // Time period when address was/is in use
    
    private enum use{home, work, temp, old, billing};
    
    private enum type{postal, physical, both};
    
    private String text;
    
    private String line[];
    
    private String city;
    
    private String district;
    
    private String state;
    
    private String postalCode;
    
    private String country;
    
    Period period = new Period();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getLine() {
        return line;
    }

    public void setLine(String[] line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    
    
}


