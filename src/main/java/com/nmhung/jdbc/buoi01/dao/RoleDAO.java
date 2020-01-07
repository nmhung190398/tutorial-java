package com.nmhung.jdbc.buoi01.dao;

import com.nmhung.jdbc.buoi01.dto.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbtractDAO{

    private List<Role> executeQuery(String sql) {
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

    public List<Role> findAll(){
        String sql = "select * from role;";
        return executeQuery(sql);
    }
}
