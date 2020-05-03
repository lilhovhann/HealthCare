package io.project.app.patientcare.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */

@Entity
@Table(name = "user")
public class Account implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 50)
    @Column(name = "email")
    private String email;
            
    @Size(max = 50)
    @Column(name = "password")
    private String password;

    @Size(max = 50)
    @Column(name = "accountType")
    private String accountType;
    
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    
    @Size(max = 50)
    @Column(name = "gender")
    private String gender;
   
    @Column(name = "birthdate")
    private Date birthdate;
    
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;

    @Column(name = "registerDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registerDate;  

    public Account(String phone, String hashPassword, String firstname, String lastname, String accountType, Date date) {
        this.phone = phone;
        this.password = hashPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountType = accountType;
        this.registerDate = date;
    }

//    public Account(Patient patient, Practitioner toPractitioner, String visitReason, Date visitDate) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


}
