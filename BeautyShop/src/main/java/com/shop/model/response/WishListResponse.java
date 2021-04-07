package com.shop.model.response;

import com.shop.common.annotation.Column;

public class WishListResponse {
    private Integer id;
    private Integer soLuongBan;
    private Integer idUser;

    public WishListResponse(Integer id, Integer soLuongBan, Integer idUser) {
        this.id = id;
        this.soLuongBan = soLuongBan;
        this.idUser = idUser;
    }

    public WishListResponse() {
    }

    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WishListEntity{" +
                "soLuongBan=" + soLuongBan +
                ", idUser=" + idUser +
                ", id=" + id +
                '}';
    }
}
