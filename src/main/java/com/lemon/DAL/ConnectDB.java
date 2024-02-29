/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAM
 */
public class ConnectDB {
    private static Connection conn = null;

	public static boolean open() throws ClassNotFoundException {
		          Dotenv env = Dotenv.configure().load();
		String jdbcUrl = env.get("urlDb");
		String username = env.get("user");
		String password = env.get("pass");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, username, password);
			if (conn != null) {
				return true;
			}
		} catch (SQLException error) {
			System.out.println(error);
		}
		return false;
	}

	public static Connection getConnection() {
		return conn;
	}

	public static boolean close() throws SQLException {
		try {
			conn.close();
			return true;
		} catch (SQLException error) {
			System.out.println(error);
		}
		return false;
	}
}
