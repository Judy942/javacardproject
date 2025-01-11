/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Judy
 */
public class DBConnection {

    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "T&0904";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Ket noi thanh cong");
            } catch (SQLException e) {
                System.err.println("Ket noi that bai " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Ket noi that bai " + e.getMessage());
        }
        return conn;
    }

//    public static String getPublicKey(String id) throws SQLException {
//        System.out.println("id: " + id);
//        String str_key = null;
//        Connection conn = DBConnection.connect();
////        Statement st = conn.createStatement();
//        String sql = "select * from thethanhvien where id='" + id + "'";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            str_key = rs.getString("publickey");
//        }
//        return str_key;
//    }
    public static String getPublicKey(String id) throws SQLException {
        System.out.println("id: " + id);
        String str_key = null;
        Connection conn = DBConnection.connect();
        String sql = "SELECT publickey FROM thethanhvien WHERE id='" + id + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            str_key = rs.getString("publickey");
        }
        return str_key;
    }

}
