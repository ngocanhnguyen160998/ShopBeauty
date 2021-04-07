package com.shop.converter.extend;

import com.shop.converter.impl.ConverterImpl;
import com.shop.model.entity.WishListEntity;
import com.shop.model.request.WishListRequest;
import com.shop.model.response.WishListResponse;

import java.util.ArrayList;
import java.util.List;

public class WishListConverter extends ConverterImpl<WishListRequest, WishListResponse, WishListEntity> {
    @Override
    public WishListEntity converToEntity(WishListEntity wishListEntity, WishListRequest wishListRequest) {
        return super.converToEntity(wishListEntity, wishListRequest);
    }

    @Override
    public WishListResponse converToResponse(WishListResponse wishListResponse, WishListEntity wishListEntity) {
        return super.converToResponse(wishListResponse, wishListEntity);
    }

    @Override
    public List<WishListResponse> convertToListResponse(List<WishListEntity> wishListEntities) {
        List<WishListResponse> vs = new ArrayList<>();
        for (WishListEntity wishListEntity: wishListEntities) {
            WishListResponse wishListResponse = new WishListResponse();
            wishListResponse= converToResponse(wishListResponse,wishListEntity);
            vs.add(wishListResponse);
        }
        return vs;
    }
}
