/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.command;

import com.epam.edu.command.server.Executor;

/**
 *
 * @author tmp
 */
public class CommandClient {
    public static void main(String[] args) {
        
        Executor ex = new Executor();
        
        ex.execute(new DeleteCustomer(123L));
    }
}
