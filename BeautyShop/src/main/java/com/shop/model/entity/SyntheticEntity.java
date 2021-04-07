package com.shop.model.entity;

public class SyntheticEntity {
    String maSp;
    String hinhAnh;
    String ten;
    Integer giaBan;
    Integer soLuongBan;
    Integer soLuongMua;
    Integer id;
    Integer id_myCard;
    Integer tongTien;
    Integer tongTienAll;

    public Integer getTongTienAll() {
        return tongTienAll;
    }

    public void setTongTienAll(Integer tongTienAll) {
        this.tongTienAll = tongTienAll;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getId_myCard() {
        return id_myCard;
    }

    public void setId_myCard(Integer id_myCard) {
        this.id_myCard = id_myCard;
    }

    public Integer getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Integer soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SyntheticEntity{" +
                "maSp='" + maSp + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", ten='" + ten + '\'' +
                ", giaBan=" + giaBan +
                ", soLuongBan=" + soLuongBan +
                ", soLuongMua=" + soLuongMua +
                ", id=" + id +
                ", id_myCard=" + id_myCard +
                ", tongTien=" + tongTien +
                '}';
    }
}
