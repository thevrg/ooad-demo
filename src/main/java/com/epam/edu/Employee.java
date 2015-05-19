package com.epam.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmp
 */
public class Employee extends Person {

    private double salary;
    private List<String> barmi = new ArrayList<>();
    private Employee manager;
    
    public Employee() {
    }

    public Employee(double salary, Long id, String name) {
        super(id, name);
        this.salary = salary;
    }
    
    public Employee(Employee original ){
        super(original);
        this.salary = original.salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
    
    @Override
    protected Employee clone() {
        Employee cloned = (Employee) super.clone();
        cloned.barmi = new ArrayList<>(barmi);
        return cloned;
    }

    @Override
    public String toString() {
        return "Employee{id=" + getId() + ", name=" + getName() + ", emails=" + getEmails() + "salary=" + salary + ", barmi=" + barmi + ", manager=" + manager + '}';
    }
    
}
