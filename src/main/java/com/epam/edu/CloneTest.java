/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu;

/**
 *
 * @author tmp
 */
public class CloneTest {

    public static void main(String[] args) {
        Person person = new Employee();
        person.setId(23L);
        person.setName("Peter");

        person.addEmail("email1");
        person.addEmail("email2");
        person.addEmail("email3");

        System.out.println("p: " + person);

        Person c = person.clone();
        System.out.println("c: " + c + ", c==p: " + (person == c));
        
        c.addEmail("email4");
        System.out.println("p: " + person);
        System.out.println("c: " + c);
        
        System.out.println(c.getClass().getName());
    }
}
