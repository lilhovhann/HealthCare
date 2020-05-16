/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.patientcare.Consent;

/**
 *
 * @author gegham
 */
public class Consent {
    private String identifier;
     
    private String status;
       
    private String scope;
         
    private String category;
       
    private String patient;
        
    private String datetime;  
          
     
    private String performer;  
            
    private String organization;
    
    Source soyrce= new Source();
    
    Policy policy = new Policy();
    
    private String policyrule;
    
    Verification verification = new Verification();
    
    Provision provision = new Provision();
    
    
              
              
    
}
