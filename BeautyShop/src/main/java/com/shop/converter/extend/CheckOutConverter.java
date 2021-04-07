package com.shop.converter.extend;

import com.shop.converter.impl.ConverterImpl;
import com.shop.model.entity.CardEntity;
import com.shop.model.entity.CheckOutEntity;
import com.shop.model.request.CheckOutRequest;
import com.shop.model.response.CardResponse;
import com.shop.model.response.CheckOutResponse;

import java.util.ArrayList;
import java.util.List;

public class CheckOutConverter extends ConverterImpl<CheckOutRequest, CheckOutResponse, CheckOutEntity> {
    @Override
    public CheckOutEntity converToEntity(CheckOutEntity checkOutEntity, CheckOutRequest checkOutRequest) {
        return super.converToEntity(checkOutEntity, checkOutRequest);
    }

    @Override
    public CheckOutResponse converToResponse(CheckOutResponse checkOutResponse, CheckOutEntity checkOutEntity) {
        return super.converToResponse(checkOutResponse, checkOutEntity);
    }

    @Override
    public List<CheckOutResponse> convertToListResponse(List<CheckOutEntity> checkOutEntities) {
        List<CheckOutResponse> vs = new ArrayList<>();
        for (CheckOutEntity checkOutEntity: checkOutEntities) {
            CheckOutResponse checkOutResponse = new CheckOutResponse();
            checkOutResponse= converToResponse(checkOutResponse,checkOutEntity);
            vs.add(checkOutResponse);
        }
        return vs;
    }
}
