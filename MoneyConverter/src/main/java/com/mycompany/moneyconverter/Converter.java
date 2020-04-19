package com.mycompany.moneyconverter;
import java.util.Scanner;

/**
 *
 * @author lilith
 */
public class Converter {
    public static void main(String[] args) {
        System.out.println("This program will convert euro, dollar or rubli to dram");
        System.out.println("Enter what you want to convert (euro, dollar or rubli)");
        System.out.println("I want to convert: ");
        Scanner typeObj = new Scanner(System.in);  
        String type = typeObj.nextLine();
        System.out.println("enter value: ");
        Scanner valueObj = new Scanner(System.in);
        double value = valueObj.nextDouble();
        
        convertMoney convertObj = new convertMoney();
        switch(type){
            case("euro"):
                 System.out.printf("%.2f %s is %.2f dram", value, type, convertObj.euroToDram(value));
                 break;
            case("dollar"):
                 System.out.printf("%.2f %s is %.2f dram", value, type, convertObj.dollarToDram(value));
                 break;
            case("rubli"):
                System.out.printf("%.1f %s is %.2f dram", value, type, convertObj.rubliToDram(value));
                break;
            default:
                System.out.println("try again");
        }
    
    }
    
}

class convertMoney{
    
    double euroToDram(double value){
        return value*526.267;
    }
    
    double dollarToDram(double value){
        return value*483.96;
    }
    
    double rubliToDram(double value){
        return value*6.53;
    }
}
