package com.epam.edu.decorator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author tmp
 */
public class DecoratorDemo {
    public static void main(String[] args) throws IOException, UnsupportedEncodingException {
        try(BufferedReader br = new BufferedReader(new CharacterChangerFilterReader(new InputStreamReader(new FileInputStream("target/classes/alma.xml"), "UTF-8")))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
            
    }
}
