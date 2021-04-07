package com.shop.converter.extend;

import com.shop.converter.impl.ConverterImpl;
import com.shop.model.entity.CardEntity;
import com.shop.model.request.CardRequest;
import com.shop.model.response.CardResponse;

import java.util.ArrayList;
import java.util.List;

public class CardConverter extends ConverterImpl<CardRequest, CardResponse, CardEntity> {
    @Override
    public CardEntity converToEntity(CardEntity cardEntity, CardRequest cardRequest) {
        return super.converToEntity(cardEntity, cardRequest);
    }

    @Override
    public CardResponse converToResponse(CardResponse cardResponse, CardEntity cardEntity) {
        return super.converToResponse(cardResponse, cardEntity);
    }

    @Override
    public List<CardResponse> convertToListResponse(List<CardEntity> cardEntities) {
        List<CardResponse> vs = new ArrayList<>();
        for (CardEntity cardEntity: cardEntities) {
            CardResponse cardResponse = new CardResponse();
            cardResponse= converToResponse(cardResponse,cardEntity);
            vs.add(cardResponse);
        }
        return vs;
    }
}
