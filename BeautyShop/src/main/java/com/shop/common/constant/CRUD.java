package com.shop.common.constant;

public enum CRUD {
    LIST("list"),
    EDIT("edit");

    CRUD(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
