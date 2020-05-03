package io.project.app.patientcare.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.project.app.patientcare.models.Account;

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
@Table(name = "visit")
public class Visit implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "visitId")
    private Long visitId;

    @Size(max = 50)
    @Column(name = "visitDate")
    private String visitDate;

    @Size(max = 50)
    @Column(name = "patientPhone")
    private String patientPhone;

    @Column(name = "patientId")
    private Long patientId;
    

    @Size(max = 50)
    @Column(name = "practitionerId")
    private String practitionerId;

    //private Practitioner toPractitioner = new Practitioner();
    @Size(max = 50)
    @Column(name = "firstname")
    private String visitReason;

    public Visit(String visitDate, String patientPhone, Long patientId, String practitionerId, String visitReason) {
        this.visitDate = visitDate;
        this.patientPhone = patientPhone;
        this.patientId = patientId;
        this.practitionerId = practitionerId;
        this.visitReason = visitReason;

    }

    public Long setPatientId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
