/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class ConverterService {

    private static final double EURO_RATE = 520;
    private static final double DOLLAR_RATE = 483;
    private static final double RUBLI_RATE = 7;

    public double convertFromDramToEuro(double dramAmount) {
        
        log.info("I am normal log");
        log.error("I am error log");

        final double result = dramAmount / EURO_RATE;
        return result;
    }
    
    public double convertFromDramToDollar(double dramAmount){
        
        log.info("I am normal log");
        log.error("I am error log");
        
        final double result = dramAmount / DOLLAR_RATE ;
        return result;
    }    
    
     public double convertFromDramToRubli(double dramAmount){
        
        log.info("I am normal log");
        log.error("I am error log");
        
        final double result = dramAmount / RUBLI_RATE;
        return result;
    }  


}
