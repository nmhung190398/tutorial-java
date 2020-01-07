package com.nmhung.jdbc.buoi01;

import com.nmhung.jdbc.buoi01.dto.Role;
import com.nmhung.jdbc.buoi01.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bai02 {
    Connection con;

    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String user = "root";
        String pass = "123456";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException e) {
            return null;
        }
    }


    private List<User> executeQuery(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
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
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }

        }

    }

    private List<Role> getRole(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
            List<Role> list = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                list.add(role);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
    }


    public List<User> findAll() {
        String sql = "select * from user";
        return executeQuery(sql);
    }

    public User login(String username, String password) {
        String sql = "select * from user where username = '" + username + "' and password = '" + password + "';";
        List<User> users = executeQuery(sql);
        return users.isEmpty() ? null : users.get(0);
    }

    public static void main(String[] args) {
        Bai02 bai02 = new Bai02();
        String sql = "select * from role;";
        System.out.println(bai02.getRole(sql));

    }


}
