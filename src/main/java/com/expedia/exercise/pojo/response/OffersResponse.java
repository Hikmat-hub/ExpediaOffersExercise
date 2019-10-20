package com.expedia.exercise.pojo.response;

import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;
import lombok.Data;

@Data
public class OffersResponse extends Response {

    private OfferExpediaResponse offerResponse;

}
