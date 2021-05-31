package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

	public static Connection makeConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lnt_final_project_db?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(connection == null) {
			System.out.println("Connection error");
		}else {
			System.out.println("Connecting Successful");
		}
		
		return connection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
