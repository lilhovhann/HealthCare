/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patient.submodels;

import java.util.Date;

/**
 *
 * @author lilith
 */
public class Period {
//     "start" : "<dateTime>", // C? Starting time with inclusive boundary
//      "end" : "<dateTime>"
    
    public Date start;
    public Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    
}
