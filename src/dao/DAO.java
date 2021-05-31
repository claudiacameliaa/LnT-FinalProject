package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import java.sql.Statement;

import database.ConnectDatabase;

public class DAO {
	
	Connection connection;

	public DAO() throws SQLException {
		connection = ConnectDatabase.makeConnection();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}
	
	public Vector<Vector<String>> getMenuData() {
		Vector<Vector<String>> menuData = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			
			String query = "select * from datamenu";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				menuData.add(rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuData;
	}
	
	public void insertDatabase(String kodeMenu, String namaMenu, String hargaMenu, String stokMenu) {
		try {
			Statement stmt = connection.createStatement();
			
			String query = "INSERT INTO menu_db " + "VALUES ('" + kodeMenu + "', '" + namaMenu + "', '" + hargaMenu + "', '" + stokMenu + "')";
			
			System.out.println(query);
			
			stmt.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Insert data berhasil");
			System.out.println("Insert data berhasil");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDatabase(String kodeMenu, String namaMenu, String hargaMenu, String stokMenu) {
		try {
			Statement stmt = connection.createStatement();
			
			String query = "UPDATE menu_db " + "SET NamaMenu = '" + namaMenu + "', HargaMenu = '" + hargaMenu + "', StokMenu = '" + stokMenu + "' WHERE KodeMenu = '"+kodeMenu+"'";
			
			System.out.println(query);
			
			stmt.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Update data berhasil");
			System.out.println("Update data berhasil");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDatabase(String kodeMenu) {
		try {
			Statement stmt = connection.createStatement();
			
			String query = "DELETE FROM menu_db " + "WHERE kodeMenu = '"+kodeMenu+"'";
			
			System.out.println(query);
			
			stmt.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Delete data berhasil");
			System.out.println("Delete data berhasil");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
