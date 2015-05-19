/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.templatemethod;

/**
 *
 * @author tmp
 */
public class Truck extends Vehicle{

    private double tripDistance;
    
    @Override
    public double calculateFuelEfficiecy() {
        return 3;
    }

    @Override
    public double calculateTripDistance() {
        return tripDistance;
    }
    
}
