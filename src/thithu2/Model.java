/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thithu2;

/**
 *
 * @author Admin
 */
public class Model {
    private String ma;
    private String ten;
    private String pass;
    private boolean vaiTro;

    public Model() {
    }

    public Model(String ma, String ten, String pass, boolean vaiTro) {
        this.ma = ma;
        this.ten = ten;
        this.pass = pass;
        this.vaiTro = vaiTro;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
    public Object[] toDaTaRow(){
        return new Object[]{ma, ten, pass, vaiTro ? "Quản lý" : "Nhân viên"};
    }
}
