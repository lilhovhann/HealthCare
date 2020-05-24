package io.project.app.models;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */

@Document("account")
public class Account implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    
    @Id
    private String id;
    
    private String firstname;
    
    private String lastname;

    private String phone;

    private String email;

    private String password;

    private String middlename;

    private Date registerDate;

    public Account(String firstname, String lastname, String middlename, String phone, String email, String hashPassword, Date date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.middlename = middlename;
        this.password = hashPassword;
        this.registerDate = date;
    }
}
