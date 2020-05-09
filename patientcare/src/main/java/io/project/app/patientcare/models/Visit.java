package io.project.app.patientcare.models;

import java.io.Serializable;
import io.project.app.patientcare.models.Account;
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
public class Visit implements Serializable {

    private static final long serialVersionUID = 5005662345607157416L;
    @Id
    private String visitId;

    private String visitDate;

    private String patientPhone;

    private String patientId;
    
    private String practitionerId;

    private String visitReason;

    public Visit(String visitDate, String patientPhone, String patientId, String practitionerId, String visitReason) {
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
