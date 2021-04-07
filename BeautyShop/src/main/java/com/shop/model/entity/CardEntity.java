package com.shop.model.entity;

import com.shop.common.annotation.Column;
import com.shop.common.annotation.Entity;
import com.shop.common.annotation.Id;
import com.shop.common.constant.CRUD;
import com.shop.paging.PageRequest;

@Entity(name = "GIOHANG")
public class CardEntity {
    @Id(value = "id_mycart")
    private Integer id;
    @Column(value = "maSp")
    private Integer maSp;
    @Column(value = "soLuongMua")
    private Integer soLuongMua;
    @Column(value = "id_user")
    private Integer id_user;
    @Column(value = "tongtien")
    private Integer tongTien;
    @Column(value = "tinhTrang")
    private Integer tinhTrang;
    public CardEntity() {
    }

    public CardEntity(Integer id, Integer maSp, Integer soLuongMua, Integer id_user, Integer tongTien, Integer tinhTrang) {
        this.id = id;
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
        this.id_user = id_user;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public Integer getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Integer soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", maSp=" + maSp +
                ", soLuongMua=" + soLuongMua +
                ", id_user=" + id_user +
                ", tongTien=" + tongTien +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
