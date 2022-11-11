package com.javassem.basic;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import lombok.extern.log4j.Log4j;


public class JdbcTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void testConnection() {
		try {
			Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", 
					"javassem", "1234");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
