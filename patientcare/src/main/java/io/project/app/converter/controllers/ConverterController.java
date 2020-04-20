/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.converter.controllers;

import io.project.app.converter.services.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/converter")
@Slf4j
public class ConverterController {

    //private ConverterService converterService = new ConverterService();/////
    //instead of new
    @Autowired
    private ConverterService converterService;
    
 /// http://localhost:5550/api/v2/converter/euro?amount=5000
    
    @GetMapping("/dollar")
    public double convertToDollar(@RequestParam double amount){
        log.info("Starting convert");
        final double convertFromDramToDollar = converterService.convertFromDramToDollar(amount);
        return convertFromDramToDollar;
    }

    @GetMapping("/euro")
    public double convertToEuro(@RequestParam double amount) {
        log.info("Starting convert");
        final double convertFromDramToEuro = converterService.convertFromDramToEuro(amount);
        return convertFromDramToEuro;
    }
    
    
   
    @GetMapping("/rubli")
    public double convertToRubli(@RequestParam double amount){
        log.info("Starting convert");
        final double convertFromDramToRubli = converterService.convertFromDramToRubli(amount);
        return convertFromDramToRubli;
    }

}
