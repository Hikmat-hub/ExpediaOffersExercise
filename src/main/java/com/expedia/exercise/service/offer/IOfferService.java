package com.expedia.exercise.service.offer;

import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.OffersResponse;

public interface IOfferService {

    /**
     *
     * @param offersRequest
     * @return
     */
    OffersResponse filter(OffersRequest offersRequest);

}
