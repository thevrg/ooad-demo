package com.epam.edu.templatemethod;

/**
 *
 * @author tmp
 */
public abstract class Vehicle {
    public double calculateFuelNeeds() {
        return calculateTripDistance() / calculateFuelEfficiecy();
    }
    public abstract double calculateFuelEfficiecy();
    public abstract double calculateTripDistance();
}
