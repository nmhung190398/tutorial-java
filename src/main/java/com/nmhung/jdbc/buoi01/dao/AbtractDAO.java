package com.nmhung.jdbc.buoi01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbtractDAO {
    String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
    String user = "root";
    String pass = "123456";
    public Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException e) {
            return null;
        }
    }
}
