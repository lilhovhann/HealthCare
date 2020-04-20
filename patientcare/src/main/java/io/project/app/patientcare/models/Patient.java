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
@Table(name = "patient")
public class Patient implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    
    @Size(max = 50)
    @Column(name = "gender")
    private String gender;
    
    @Size(max = 50)
    @Column(name = "healthStatus")
    private String healthStatus;
    
    private boolean active;
    
    @Size(max = 50)
    @Column(name = "martialStatus")
    private String martialStatus;
    
    
    @Column(name = "birthdate")
    private Date birthdate;
    
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;
    

    @Column(name = "status")
    private Integer status;
    

    @Column(name = "patientRegisterDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date patientRegisterDate;

  
    
}
