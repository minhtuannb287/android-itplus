package vn.edu.itplus_academy.myapplication.models;

public class Ebook {
    int ID;
    String tenSach;
    String tacGia;
    String ngayNhap;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String toString(){
        return ID +". " + tenSach + " Tac gia: " + tacGia + " ngay nhap: " + ngayNhap;
    }
}
