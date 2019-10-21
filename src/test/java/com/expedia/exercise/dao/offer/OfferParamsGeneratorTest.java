package com.expedia.exercise.dao.offer;

import com.expedia.exercise.pojo.request.OffersRequest;
import org.apache.http.NameValuePair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class OfferParamsGeneratorTest {

    @Test
    public void testHasTheDefaultParams(){
        OffersRequest offersRequest = new OffersRequest();
        Map<String, String> params = new HashMap<>();
        params.put("scenario","deal-finder");
        params.put("page","foo");
        params.put("uid","foo");
        params.put("productType","Hotel");
        final List<NameValuePair> nameValuePairs = OfferParamsGenerator.generateParams(offersRequest);
        params.forEach((paramName, paramValue) -> {
            final Optional<NameValuePair> param = nameValuePairs.stream().filter(nameValuePair -> paramName.equals(nameValuePair.getName())).findFirst();
            if(!param.isPresent()){
                Assert.fail(String.format("It should the following parameter $s, with value: %s", paramName, paramValue));
            }
            Assert.assertEquals(String.format("This parameter $s, should have this value: %s", paramName, paramValue), paramValue, param.get().getValue());
        });
    }

    @Test
    public void testExpediaDateFormat(){

        final String maxStartDate = "2019-05-01";
        final String minStartDate = "2019-04-01";

        Calendar calendarMaxTripStartDate = Calendar.getInstance();
        calendarMaxTripStartDate.set(Calendar.DATE, 1);
        calendarMaxTripStartDate.set(Calendar.MONTH, 4);
        calendarMaxTripStartDate.set(Calendar.YEAR, 2019);

        Calendar calendarMinTripStartDate = Calendar.getInstance();
        calendarMinTripStartDate.set(Calendar.DATE, 1);
        calendarMinTripStartDate.set(Calendar.MONTH, 3);
        calendarMinTripStartDate.set(Calendar.YEAR, 2019);

        OffersRequest offersRequest = new OffersRequest();
        offersRequest.setMaxTripStartDate(calendarMaxTripStartDate.getTime());
        offersRequest.setMinTripStartDate(calendarMinTripStartDate.getTime());

        final List<NameValuePair> nameValuePairs = OfferParamsGenerator.generateParams(offersRequest);
        final Optional<NameValuePair> maxTripStartDate = nameValuePairs.stream().filter(nameValuePair -> "maxTripStartDate".equals(nameValuePair.getName())).findFirst();
        if(!maxTripStartDate.isPresent()){
            Assert.fail("You should have maxTripStartDate parameter");
        }
        Assert.assertEquals(maxStartDate, maxTripStartDate.get().getValue());
        final Optional<NameValuePair> minTripStartDate = nameValuePairs.stream().filter(nameValuePair -> "minTripStartDate".equals(nameValuePair.getName())).findFirst();
        if(!minTripStartDate.isPresent()){
            Assert.fail("You should have maxTripStartDate parameter");
        }
        Assert.assertEquals(minStartDate, minTripStartDate.get().getValue());
    }

}
