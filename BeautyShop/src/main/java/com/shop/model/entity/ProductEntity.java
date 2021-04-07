package com.shop.model.entity;

import com.shop.common.annotation.Column;
import com.shop.common.annotation.Entity;
import com.shop.common.annotation.Id;
import java.time.LocalDate;

@Entity(name = "sanpham")
public class ProductEntity {
    @Id(value = "maSp")
    private Integer id;
    @Column(value = "ten")
    private String tenSanPham;
    @Column(value = "hinhAnh")
    private String hinhAnh;
    @Column(value = "thongTinChiTiet")
    private String thongTinChiTiet;
    @Column(value = "giaBan")
    private Integer giaBan;
    @Column(value = "soLuong")
    private Integer soLuong;
    @Column(value = "mauSac")
    private String mauSac;
    @Column(value = "trangThai")
    private String trangThai;
    @Column(value = "ngayDang")
    private LocalDate ngayDang;
    @Column(value = "idMenuCon")
    private Integer idMenuCon;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String tenSanPham, String hinhAnh, String thongTinChiTiet, Integer giaBan, Integer soLuong, String mauSac, String trangThai, LocalDate ngayDang, Integer idMenuCon) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.hinhAnh = hinhAnh;
        this.thongTinChiTiet = thongTinChiTiet;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.trangThai = trangThai;
        this.ngayDang = ngayDang;
        this.idMenuCon = idMenuCon;
    }

    public ProductEntity(Integer id) {
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
                ", trangThai='" + trangThai + '\'' +
                ", ngayDang=" + ngayDang +
                ", idMenuCon=" + idMenuCon +
                '}';
    }
}
