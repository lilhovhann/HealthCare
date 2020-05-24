/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.api.response;

import io.project.app.models.Patient;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lilith
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientApiResponse {
    
    
     List<Patient> patientList  = new ArrayList<>();
     Patient patient = new Patient();
    
}
