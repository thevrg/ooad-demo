package com.epam.edu;

/**
 *
 * @author tmp
 */
public class Email {
    private String name;

    public Email() {
    }

    public Email(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Email{" + "name=" + name + '}';
    }
}
