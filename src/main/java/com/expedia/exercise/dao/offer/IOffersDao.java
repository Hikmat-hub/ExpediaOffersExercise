package com.expedia.exercise.dao.offer;

import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;

import java.util.Optional;

public interface IOffersDao {

    Optional<OfferExpediaResponse> getOffers(OffersRequest offersRequest);

}
