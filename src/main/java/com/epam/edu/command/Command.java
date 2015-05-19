package com.epam.edu.command;

import java.io.Serializable;

/**
 *
 * @author tmp
 */
public abstract class Command implements Serializable {
	
	private Object stateBeforeExecution;
	
    public final void execute(ExecutionContext ctx) {
    	stateBeforeExecution = ctx.getSystemState();
    	doExecute(ctx);
    }
    
    protected abstract void doExecute(ExecutionContext ctx);
    
    public void undo(ExecutionContext ctx) {
    	ctx.restoreSystemState(stateBeforeExecution);
    }
}
