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
    
//    public static void main(String[] args) {
//        try (Connection conn = DBConnection.connect()) {
//            if (conn != null) {
//                String id = "001"; // ID dưới dạng chuỗi
//                String phone = "0987654323"; // Số điện thoại dưới dạng chuỗi
//                insertUser(conn, id, phone);
//            }
//        } catch (SQLException e) {
//            System.err.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
//        }
//    }
    
        public static void insertUser(Connection conn, String id, String phone) {
        String sql = "INSERT INTO \"thethanhvien\" ( publicKey) VALUES ( ?)"; // Sử dụng dấu ngoặc kép cho tên bảng
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, id); // Chèn id dưới dạng chuỗi
            ps.setString(1, phone); // Chèn phone dưới dạng chuỗi
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm người dùng thành công: ID = " + id + ", Phone = " + phone);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm người dùng: " + e.getMessage());
        }
    }
        
    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user , password);
                System.out.println("Ket noi thanh cong");
            } catch (Exception e) {
                System.err.println("Ket noi that bai " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Ket noi that bai "+ e.getMessage());
        }
        return conn;
        
    }
    
    public static String getPublicKey(String id) throws  SQLException {
        String str_key = null;
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        String sql = "select * from user where id='" + id + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            str_key = rs.getString("publicKey");
        }
        return str_key;
    }
}