package com.shop.paging;

public class PageRequest implements Pageable {
    private int page;       //pageSize
    private int maxPageItem;      //pageIndex

    public PageRequest(int page, int maxPageItem) {
        this.page = page;
        this.maxPageItem = maxPageItem;
    }

    public PageRequest() {
    }

    public static PageRequest of(int page, int maxPageItem ){
        return new PageRequest(page, maxPageItem);
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

    @Override
    public Integer getPage() {
        return maxPageItem;
    }

    @Override
    public Integer getLimit() {
        return page;
    }

    @Override
    public Integer getOffset() {
        return ((page - 1) * maxPageItem);
    }

}
