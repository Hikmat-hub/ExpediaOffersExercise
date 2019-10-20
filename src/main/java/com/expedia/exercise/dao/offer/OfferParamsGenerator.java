package com.expedia.exercise.dao.offer;

import com.expedia.exercise.pojo.request.OffersRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible to create query params for offer service
 */
final class OfferParamsGenerator {

    /**
     *
     * @param offersRequest
     * @return
     */
    public static List<NameValuePair> generateParams(final OffersRequest offersRequest){
        final List<NameValuePair> nameValuePairs = new ArrayList<>();
        final ObjectMapper mapper = new ObjectMapper();
        nameValuePairs.addAll(getDefaultParameters());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // Convert POJO to Map
        final Map<String, Object> map =
                mapper.convertValue(offersRequest, new TypeReference<Object>() {});
        map.forEach((parameterName, parameterValue) -> nameValuePairs.add(new BasicNameValuePair(parameterName, parameterValue.toString())));
        return nameValuePairs;
    }

    private static List<NameValuePair> getDefaultParameters() {
        return Arrays.asList(new BasicNameValuePair("scenario", "deal-finder"),
                new BasicNameValuePair("page", "foo"),
                new BasicNameValuePair("uid","foo"),
                new BasicNameValuePair("productType", "Hotel"));
    }
}
