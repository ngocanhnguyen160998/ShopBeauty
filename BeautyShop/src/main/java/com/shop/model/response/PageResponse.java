package com.shop.model.response;

import com.shop.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class PageResponse<T> {
    private List<T> listResult = new ArrayList<>();
    private int page;
    private int maxPageItem;
    private int totalPage;
    private int totalItem;
    private String sortName;
    private String sortBy;
    private String type;
    private int[] ids;
    private String ten;
    private String idMenuCon;

    public String getIdMenuCon() {
        return idMenuCon;
    }

    public void setIdMenuCon(String idMenuCon) {
        this.idMenuCon = idMenuCon;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(int maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
