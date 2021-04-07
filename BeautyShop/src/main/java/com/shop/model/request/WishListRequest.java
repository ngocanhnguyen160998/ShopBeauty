package com.shop.model.request;

public class WishListRequest {
    private Integer id;
    private Integer soLuongBan;
    private Integer idUser;

    public WishListRequest(Integer id, Integer soLuongBan, Integer idUser) {
        this.id = id;
        this.soLuongBan = soLuongBan;
        this.idUser = idUser;
    }

    public WishListRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "WishListEntity{" +
                "soLuongBan=" + soLuongBan +
                ", idUser=" + idUser +
                '}';
    }
}
