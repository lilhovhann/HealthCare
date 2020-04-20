package io.project.app.converter.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
public class Visit implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    private String id;
    
    private Date visitDate;
    private Patient patient = new Patient();
    private Practitioner toPractitioner = new Practitioner();
    private String visitReason;
    private String visitResult;
    private boolean needForCare;
    private List<String> medicineListForPatient = new ArrayList<>();
    
}
