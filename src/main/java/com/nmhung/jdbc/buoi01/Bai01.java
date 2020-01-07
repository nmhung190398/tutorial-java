package com.nmhung.jdbc.buoi01;


import com.nmhung.jdbc.buoi01.dto.Animals;
import com.nmhung.jdbc.buoi01.dto.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setId(rs.getInt("id_role"));
				list.add(user);
			}
			list.forEach(item ->{
				System.out.println(item.getId() + "\t" + item.getFullname());
			});
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
