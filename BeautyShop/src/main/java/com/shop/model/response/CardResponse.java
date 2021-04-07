package com.shop.model.response;

public class CardResponse {
    private Integer id;
    private Integer maSp;
    private Integer soLuongMua;
    private Integer id_user;
    private Integer tongTien;
    private Integer tinhTrang;



    public CardResponse() {
    }

    public CardResponse(Integer id, Integer maSp, Integer soLuongMua, Integer id_user, Integer tongTien, Integer tinhTrang) {
        this.id = id;
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
        this.id_user = id_user;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public CardResponse(Integer maSp, Integer soLuongMua, Integer id_user, Integer tongTien) {
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
        this.id_user = id_user;
        this.tongTien = tongTien;
    }

    public CardResponse(Integer id, Integer maSp, Integer soLuongMua, Integer id_user, Integer tongTien) {
        this.id = id;
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
        this.id_user = id_user;
        this.tongTien = tongTien;
    }

    public CardResponse(Integer maSp, Integer soLuongMua, Integer id_user) {
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
        this.id_user = id_user;
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
        return "CardResponse{" +
                "id=" + id +
                ", maSp=" + maSp +
                ", soLuongMua=" + soLuongMua +
                ", id_user=" + id_user +
                ", tongTien=" + tongTien +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
