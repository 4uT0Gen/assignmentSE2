package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    protected static Connection getConnect() throws Exception {
        Connection connect = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybansach?useUnicode=true&characterEncoding=utf-8", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connect;
    }
    public static void main(String[] args) throws Exception
    {
        String query="select * from SACH";
        System.out.println("Ma sach");
        PreparedStatement ps;
                ps = (PreparedStatement) getConnect().prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    System.out.println("Ma sach" + MaSach + "-"+ TenSach);
                }
    }
}
