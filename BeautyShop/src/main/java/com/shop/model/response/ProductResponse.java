package com.shop.model.response;

import java.time.LocalDate;

public class ProductResponse {
    private Integer id;
    private String tenSanPham;
    private String hinhAnh;
    private String thongTinChiTiet;
    private Integer giaBan;
    private Integer soLuong;
    private String mauSac;
    private String size;
    private String tag;
    private String trangThai;
    private LocalDate ngayDang;
    private Integer idMenuCon;

    public ProductResponse() {
    }

    public ProductResponse(Integer id, String tenSanPham, String hinhAnh, String thongTinChiTiet, Integer giaBan, Integer soLuong, String mauSac, String size, String tag, String trangThai, LocalDate ngayDang, Integer idMenuCon) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.hinhAnh = hinhAnh;
        this.thongTinChiTiet = thongTinChiTiet;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.size = size;
        this.tag = tag;
        this.trangThai = trangThai;
        this.ngayDang = ngayDang;
        this.idMenuCon = idMenuCon;
    }

    public ProductResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getThongTinChiTiet() {
        return thongTinChiTiet;
    }

    public void setThongTinChiTiet(String thongTinChiTiet) {
        this.thongTinChiTiet = thongTinChiTiet;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDate getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDate ngayDang) {
        this.ngayDang = ngayDang;
    }

    public Integer getIdMenuCon() {
        return idMenuCon;
    }

    public void setIdMenuCon(Integer idMenuCon) {
        this.idMenuCon = idMenuCon;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "tenSanPham='" + tenSanPham + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", thongTinChiTiet='" + thongTinChiTiet + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", mauSac='" + mauSac + '\'' +
                ", size='" + size + '\'' +
                ", tag='" + tag + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayDang=" + ngayDang +
                ", idMenuCon=" + idMenuCon +
                '}';
    }
}
