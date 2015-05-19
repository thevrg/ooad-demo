/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.visitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author tmp
 */
public class VisitorDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("target/classes/alma.xml"), new DefaultHandler(){

            @Override
            public void startDocument() throws SAXException {
                System.out.println("startDocument");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("endDocument");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("startElement " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("endElement: " + qName );
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("characters: " + new String(ch, start, length));
            }
        });
    }
}
