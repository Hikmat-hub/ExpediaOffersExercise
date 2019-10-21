package com.expedia.exercise.dao.offer;

import com.expedia.exercise.config.Application;
import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class OffersDaoImplTest {

    @Autowired
    private IOffersDao offersDao;

    @Test
    public void testServiceCall(){
        OffersRequest offersRequest = new OffersRequest();
        final Optional<OfferExpediaResponse> offers = offersDao.getOffers(offersRequest);
        Assert.assertTrue(offers.isPresent());
        Assert.assertNotNull(offers.get().getOffers());
    }

}
