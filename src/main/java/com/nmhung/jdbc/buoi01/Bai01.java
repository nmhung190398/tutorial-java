package com.nmhung.jdbc.buoi01;


import java.sql.*;

public class Bai01 {

	public static void main(String[] args) {
		//ahaihi đồ ngốc
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}

		String URL = "jdbc:mysql://127.0.0.1:3306/jdbc";
		String USER = "root";
		String PASS = "123456";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println(conn);
			//spring swing

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			//String sql = "SELECT id, first, last, age FROM Registration";
			String sql = "select id, name from animals";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");

				// Display values
				System.out.println(id + "\t" + name);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
