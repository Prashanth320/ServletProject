package com.prashanth.Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String dbURL = null;
	private static String dbUname = null;
	private static String dbPwd = null;
	private static String dbDriver = null;

	static {
		FileInputStream fis;
		try {
			InputStream iis = Thread.currentThread().getContextClassLoader().getResourceAsStream("DBConfig.properties");
			Properties prop = new Properties();
			dbURL = prop.getProperty("DB_URL");
			dbUname = prop.getProperty("DB_UNAME");
			dbPwd = prop.getProperty("DB_PWD");
			dbDriver = prop.getProperty("DB_DRIVER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConection() {
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL, dbUname, dbPwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}
