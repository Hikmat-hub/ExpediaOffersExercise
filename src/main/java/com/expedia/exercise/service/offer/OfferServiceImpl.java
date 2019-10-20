package com.expedia.exercise.service.offer;

import com.expedia.exercise.dao.offer.IOffersDao;
import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.OffersResponse;
import com.expedia.exercise.pojo.response.Response;
import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OfferServiceImpl implements IOfferService {

    @Autowired
    private IOffersDao offersDao;

    @Override
    public OffersResponse filter(OffersRequest offersRequest) {
        final OffersResponse offersResponse = new OffersResponse();
        final Optional<OfferExpediaResponse> offers = offersDao.getOffers(offersRequest);
        if(offers.isPresent()){
            offersResponse.setStatus(Response.Status.SUCCESS);
            offersResponse.setOfferResponse(offers.get());
            return offersResponse;
        }
        offersResponse.setStatus(Response.Status.ERROR);
        return offersResponse;
    }
}
