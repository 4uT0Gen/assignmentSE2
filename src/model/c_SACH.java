package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class c_SACH {

    public static int themSACH(m_SACH sach) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "insert into SACH (MaTheLoai,TenSach,MaNXB,MaTacGia,NamXuatBan,SoLuongTon,SoTrang,KhoiLuong,NgonNgu,TomTat,GiaBia,KhuyenMai,GiaBan,Diem,LinkAnh) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setInt(1, sach.getMaTheLoai());
                ps.setString(2, sach.getTenSach());
                ps.setInt(3, sach.getMaNXB());
                ps.setInt(4, sach.getMaTacGia());
                ps.setInt(5, sach.getNamXuatBan());
                ps.setInt(6, sach.getSoLuongTon());
                ps.setInt(7, sach.getSoTrang());
                ps.setString(8, sach.getKhoiLuong());
                ps.setString(9, sach.getNgonNgu());
                ps.setString(10, sach.getTomTat());
                ps.setInt(11, sach.getGiaBia());
                ps.setInt(12, sach.getKhuyenMai());
                ps.setInt(13, sach.getGiaBan());
                ps.setInt(14, sach.getDiem());
                ps.setString(15, sach.getLinkAnh());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<m_SACH> getlistSachMoiNhat(int i) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH ORDER BY MaSach DESC LIMIT 3 offset " + i * 3;
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
    public static List<m_SACH> getlistSachMoiNhat(int i,int gt) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH ORDER BY MaSach DESC LIMIT " +gt +" offset " + i * gt;
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<m_SACH> timKiem(String ten) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "SELECT * FROM SACH WHERE TenSach LIKE '%" + ten + "%'";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<m_SACH> cungTacGia(int i, int maTacGia) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where  MaTacGia = '" + maTacGia + "' LIMIT 3 offset " + i * 3;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

     public static String timTenSachThemMa(int ma){
        List<m_SACH> list = new ArrayList<m_SACH>();
        String tenS = "";
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from Sach where MaSach =' " + ma + "'";
                PreparedStatement ps;
                ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    tenS = rs.getString("TenSach");
                }
                return tenS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenS;
    }
     
    public static m_SACH timSachTheoMa(int maSach) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where MaSach = '" + maSach + "'";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    m_SACH s = new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh);
                    return s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static m_SACH timSachTheoTen(String ten) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where TenSach = '" + ten + "'";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    m_SACH s = new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh);
                    return s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<m_SACH> getlistSachGiamGia(int i) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH ORDER BY KhuyenMai DESC LIMIT 3 offset " + i * 3;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<m_SACH> getlistYeuThich(int i) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH ORDER BY Diem DESC LIMIT 3 offset " + i * 3;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int xoaSach(int ma) {
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "delete from SACH where MaSach='" + ma + "'";
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

    public static int suaSach(m_SACH s) {
        try {
            try (Connection con = Connect.getConnect()) {
                //String sql = "UPDATE SACH set TenSach='" + s.getTenSach() + "',NamXuatBan='" + s.getNamXuatBan() + "',SoLuongTon=" + s.getSoLuongTon() + ",SoTrang=" + s.getSoTrang() + ",KhoiLuong='" + s.getKhoiLuong() + "',NgonNgu='" + s.getNgonNgu() + "',TomTat='" + s.getTomTat() + "',GiaBia=" + s.getGiaBia() + ",KhuyenMai=" + s.getKhuyenMai() + ",GiaBan=" + s.getGiaBan() + ",LinkAnh='" + s.getLinkAnh() + "' where MaSach=" + s.getMaSach();
                 String sql = "UPDATE SACH set TenSach='Nhật ngữ',NamXuatBan='" + s.getNamXuatBan() + "',SoLuongTon=" + s.getSoLuongTon() + ",SoTrang=" + s.getSoTrang() + ",KhoiLuong='" + s.getKhoiLuong() + "',NgonNgu='" + s.getNgonNgu() + "',TomTat='" + s.getTomTat() + "',GiaBia=" + s.getGiaBia() + ",KhuyenMai=" + s.getKhuyenMai() + ",GiaBan=" + s.getGiaBan() + ",LinkAnh='" + s.getLinkAnh() + "' where MaSach=" + s.getMaSach();
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

    public static int diem(int maSach) {
        int d = 0;
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where MaSach = '" + maSach + "'";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    d = rs.getInt("Diem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static int congDiem(int diem, int maSach) {
        int d = c_SACH.diem(maSach);
        d = d + diem;
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "UPDATE SACH SET diem='" + d + "' WHERE MaSach='" + maSach + "'";
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

    public static List<m_SACH> getlistbyNXB(int i, int maNXB) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where MaNXB = '" + maNXB + "' LIMIT 9 offset " + i * 9;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<m_SACH> getlistbyTacGia(int i, int maTacGia) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where  MaTacGia = '" + maTacGia + "' LIMIT 9 offset " + i*9;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<m_SACH> getlistbyTheLoai(int i, int maTheLoai) {
        List<m_SACH> list = new ArrayList<m_SACH>();
        try {
            try (Connection con = Connect.getConnect()) {
                String sql = "select * from SACH where MaTheLoai = '" + maTheLoai + "' LIMIT 9 offset " + i * 9;
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int MaSach = rs.getInt("MaSach");
                    int MaTheLoai = rs.getInt("MaTheLoai");
                    String TenSach = rs.getString("TenSach");
                    int MaNXB = rs.getInt("MaNXB");
                    int MaTacGia = rs.getInt("MaTacGia");
                    int NamXuatBan = rs.getInt("NamXuatBan");
                    int SoLuongTon = rs.getInt("SoLuongTon");
                    int SoTrang = rs.getInt("SoTrang");
                    String KhoiLuong = rs.getString("KhoiLuong");
                    String NgonNgu = rs.getString("NgonNgu");
                    String TomTat = rs.getString("TomTat");
                    int GiaBia = rs.getInt("GiaBia");
                    int KhuyenMai = rs.getInt("KhuyenMai");
                    int GiaBan = rs.getInt("GiaBan");
                    int Diem = rs.getInt("Diem");
                    String LinkAnh = rs.getString("LinkAnh");
                    list.add(new m_SACH(MaSach, MaTheLoai, TenSach, MaNXB, MaTacGia, NamXuatBan, SoLuongTon, SoTrang, KhoiLuong, NgonNgu, TomTat, GiaBia, KhuyenMai, GiaBan, Diem, LinkAnh));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
