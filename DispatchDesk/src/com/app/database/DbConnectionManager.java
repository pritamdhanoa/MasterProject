/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {

	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException {
		try {
			if (connection == null) {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xpressmessagedb",
						DBCredentials.USER, DBCredentials.PASS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
