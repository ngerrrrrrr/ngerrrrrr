/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thithu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Repositories {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_NhanVien> getAll() {
        sql = "select MaNV, HoTen, MatKhau, VaiTro from NhanVien";
        ArrayList<Model_NhanVien> list_NV = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String pass = rs.getString(3);
                boolean vaiTro = rs.getBoolean(4);
                list_NV.add(new Model_NhanVien(ma, ten, pass, vaiTro));
            }
            return list_NV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(Model_NhanVien m) {
        sql = "insert into NhanVien(MaNV, HoTen, MatKhau, VaiTro) values(?,?,?,?)";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMa());
            ps.setObject(2, m.getTen());
            ps.setObject(3, m.getPass());
            ps.setObject(4, m.getVaiTro());
            
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int sua(String ma, Model_NhanVien m){
        sql = "update NhanVien set HoTen = ?, MatKhau = ?, VaiTro = ? where MaNV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getPass());
            ps.setObject(3, m.getVaiTro());
            ps.setObject(4, m.getMa());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(String maXoa){
        sql = "delete from KhoaHoc where MaNV = ?\n"
              + "delete from NguoiHoc where MaNV = ?\n"
              + "delete from NhanVien where MaNV = ?";
         try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maXoa);
            ps.setObject(2, maXoa);
            ps.setObject(3, maXoa);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public Model_NhanVien checkTrung(String maMoi){
        Model_NhanVien m = null;
        
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maMoi);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String pass = rs.getString(3);
                boolean vaiTro = rs.getBoolean(4);
                m = new Model_NhanVien(ma, ten, pass, vaiTro);
            }
            return m;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
