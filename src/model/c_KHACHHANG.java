package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class c_KHACHHANG {
    public static int themKHACHHANG(m_KHACHHANG bc) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "insert into KHACHHANG  (TenKH,DiaChi,Email,SDT,MatKhau) value (?,?,?,?,?)";
                PreparedStatement ps;
                try {
                    ps = (PreparedStatement) con.prepareStatement(sql);
                    ps.setString(1, bc.getTenKH());
                    ps.setString(2, bc.getDiaChi());
                    ps.setString(3, bc.getEmail());
                    ps.setString(4, bc.getSDT());
                    ps.setString(5, bc.getMatKhau());
                    return ps.executeUpdate();
                } catch (Exception o) {
                    o.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<m_KHACHHANG> getlist(int i){
        List<m_KHACHHANG> list = new ArrayList<m_KHACHHANG>();
      
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from KHACHHANG ORDER BY MaKH DESC LIMIT 10 offset " + i * 10;
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaKH = rs.getInt("MaKH");
                    String TenKH = rs.getString("TenKH");
                    String DiaChi = rs.getString("DiaChi");
                    String Email = rs.getString("Email");
                    String SDT = rs.getString("SDT");
                    String MatKhau = rs.getString("MatKhau");
                    list.add(new m_KHACHHANG(MaKH, TenKH, DiaChi, Email, SDT, MatKhau));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int DangNhap(String email, String pass) {
        int i = 0;
        List<m_KHACHHANG> list = new ArrayList<m_KHACHHANG>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from KHACHHANG where Email ='" + email + "' and MatKhau = '" + pass + "'";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    i = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int KiemTra(String email) {
        int i = 0;
        List<m_KHACHHANG> list = new ArrayList<m_KHACHHANG>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from KHACHHANG where Email ='" + email + "'";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    i = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static m_KHACHHANG kh_email(String email) {
        List<m_KHACHHANG> list = new ArrayList<m_KHACHHANG>();
        m_KHACHHANG a = new m_KHACHHANG();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from KHACHHANG where Email ='" + email + "'";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    a.setDiaChi(rs.getString("DiaChi"));
                    a.setEmail(rs.getString("Email"));
                    a.setMaKH(rs.getInt("MaKH"));
                    a.setMatKhau(rs.getString("MatKhau"));
                    a.setSDT(rs.getString("SDT"));
                    a.setTenKH(rs.getString("TenKH"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    
      public static int suaKHACHHANG(m_KHACHHANG m) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "UPDATE KHACHHANG SET TenKH='"+ m.getTenKH() +"' , DiaChi='"+ m.getDiaChi() +"', SDT='"+ m.getSDT() + "', MatKhau='"+ m.getMatKhau()+"', Email ='" + m.getEmail() +"'where MaKH=" + m.getMaKH();
                PreparedStatement ps;
                try {
                    ps = (PreparedStatement) con.prepareStatement(sql);
                    return ps.executeUpdate();
                } catch (Exception o) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
      
       public static int xoaKHACHHANG(int ma) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "delete from KHACHHANG where MaKH='" + ma + "'";
                PreparedStatement ps;
                try {
                    ps = (PreparedStatement) con.prepareStatement(sql);
                    return ps.executeUpdate();
                } catch (Exception o) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

