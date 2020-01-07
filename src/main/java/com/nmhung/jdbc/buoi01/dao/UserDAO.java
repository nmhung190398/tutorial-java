package com.nmhung.jdbc.buoi01.dao;

import com.nmhung.jdbc.buoi01.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbtractDAO{

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

    public List<User> findAll() {
        String sql = "select * from user";
        return executeQuery(sql);
    }

    public User login(String username, String password) {
        String sql = "select * from user where username = '" + username + "' and password = '" + password + "';";
        List<User> users = executeQuery(sql);
        return users.isEmpty() ? null : users.get(0);
    }
}
