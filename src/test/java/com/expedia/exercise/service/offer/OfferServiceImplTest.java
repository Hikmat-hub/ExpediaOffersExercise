package com.expedia.exercise.service.offer;

import com.expedia.exercise.dao.offer.IOffersDao;
import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.OffersResponse;
import com.expedia.exercise.pojo.response.Response;
import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class OfferServiceImplTest {

    @Mock
    private IOffersDao offersDao;

    @InjectMocks
    private IOfferService offerService = new OfferServiceImpl();

    @Test
    public void testErrorResponse(){
        Mockito.when(offersDao.getOffers(ArgumentMatchers.any(OffersRequest.class))).thenReturn(Optional.empty());
        final OffersResponse offersResponse = offerService.filter(new OffersRequest());
        Assert.assertEquals(Response.Status.ERROR, offersResponse.getStatus());

    }

    @Test
    public void testOkResponse(){
        Mockito.when(offersDao.getOffers(ArgumentMatchers.any(OffersRequest.class))).thenReturn(Optional.of(new OfferExpediaResponse()));
        final OffersResponse offersResponse = offerService.filter(new OffersRequest());
        Assert.assertEquals(Response.Status.SUCCESS, offersResponse.getStatus());
    }

}
