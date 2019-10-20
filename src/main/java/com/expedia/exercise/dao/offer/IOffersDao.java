package com.expedia.exercise.dao.offer;

import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.offer.OfferResponse;

import java.util.List;
import java.util.Optional;

public interface IOffersDao {

    Optional<OfferResponse> getOffers(OffersRequest offersRequest);

}
