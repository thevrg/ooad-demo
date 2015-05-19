/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.command.server;

import com.epam.edu.command.Command;
import com.epam.edu.command.ExecutionContext;

/**
 *
 * @author tmp
 */
public class Executor {
    
    private ExecutionContext ctx = new ServerSideExecutionContext();
    
    public void execute(Command command) {
        command.execute(ctx);
    }
 
}
