package vn.edu.itplus_academy.myapplication.models;

import java.util.Date;

public class NoteItem {
    int id;
    String tieu_de;
    String noi_dung;
    boolean trang_thai;
    Date ngay_cap_nhat;

    public NoteItem() {
    }

    public NoteItem(int id, String tieu_de, String noi_dung, boolean trang_thai) {
        this.id = id;
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.trang_thai = trang_thai;
    }

    @Override
    public String toString() {
        return "NoteItem{" +
                "id=" + id +
                ", tieu_de='" + tieu_de + '\'' +
                ", noi_dung='" + noi_dung + '\'' +
                ", trang_thai=" + trang_thai +
                ", ngay_cap_nhat=" + ngay_cap_nhat +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTieu_de() {
        return tieu_de;
    }

    public void setTieu_de(String tieu_de) {
        this.tieu_de = tieu_de;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public Date getNgay_cap_nhat() {
        return ngay_cap_nhat;
    }

    public void setNgay_cap_nhat(Date ngay_cap_nhat) {
        this.ngay_cap_nhat = ngay_cap_nhat;
    }
}
