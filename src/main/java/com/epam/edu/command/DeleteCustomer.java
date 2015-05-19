/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.command;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tmp
 */
public class DeleteCustomer extends Command {

	private final Long customerId;

	public DeleteCustomer(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public void doExecute(ExecutionContext ctx) {
		try (Connection conn = ctx.getConnection()) {
			// conn.prepareStatement("delete from customer where customerId= ?);
			ctx.deleteEntity(Customer.class, customerId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
