package com.epam.edu;

import com.epam.edu.bridge.impl.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tmp
 */
public class Person implements Entity {

    private Long id;
    private String name;
    private ArrayList<Email> emails = new ArrayList<Email>();

    public Person() {
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Person(Person original) {
        this.id = original.id;
        this.name = original.name;
        this.emails = new ArrayList<>(original.emails);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void addEmail(String email) {
        emails.add(new Email(email));
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", emails=" + emails + '}';
    }

    @Override
    protected Person clone() {
        try {
            Person clone = (Person) getClass().newInstance();
            clone.id = this.id;
            clone.name = this.name;
            clone.emails = (ArrayList<Email>) emails.clone();
            return clone;
//        } catch (CloneNotSupportedException ex) {
//            throw new RuntimeException("This never happens", ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Baj van...");
        }
    }

}
