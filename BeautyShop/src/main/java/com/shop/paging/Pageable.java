package com.shop.paging;

public interface Pageable {
    Integer getPage();
    Integer getLimit();
    Integer getOffset();

}
