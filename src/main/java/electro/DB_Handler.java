package electro;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DB_Handler {
	Connection dbConnection;
	String dbName, dbHost, dbPort;
	String path;

	public Connection getMYSQLConnection() {
		try {
			dbName = getProperties("localDB_name");
			dbHost = getProperties("localHost");
			dbPort = getProperties("localPort");

//		dbName = getProperties("remoteDB_name");
//		dbHost = getProperties("remoteHost");
//		dbPort = getProperties("remotePort");

			String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

			Class.forName("com.mysql.cj.jdbc.Driver");                // points on a driver we will use
			dbConnection = DriverManager.getConnection(connectionString, getProperties("localUsername"), getProperties("localPassword"));
//		dbConnection = DriverManager.getConnection(connectionString, getProperties("remoteUsername"), getProperties("remotePassword"));
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return dbConnection;
		
		
	}
	
	String getProperties(String propName) {
		String propValue = "";
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(new File("dbConfigs.properties")));
			propValue = prop.getProperty(propName);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return propValue;
	}


	public Connection getSQLiteConnection(){
			try {
//				System.out.println("PATH = " + path);
				try {
					path = getProperties("dbPath");
					String url = path;
					System.out.println("URL = " + url);
					dbConnection = DriverManager.getConnection(url);
					System.out.println("Connection to SQLite has been established.");
					return dbConnection;
				}catch(Exception ex){
					AdditionalWindows.ChooseDB choose = new AdditionalWindows().new ChooseDB();
//					choose.setVisible(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}