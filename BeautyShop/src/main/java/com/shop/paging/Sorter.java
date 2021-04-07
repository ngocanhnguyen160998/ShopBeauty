package com.shop.paging;

public class Sorter {
    private String sortName;
    private String sortBy;
    private Sorter sorter;
    public Sorter(String sortName, String sortBy, Sorter sorter) {
        this.sortName = sortName;
        this.sortBy = sortBy;
        this.sorter = sorter;
    }

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
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
