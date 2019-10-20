package com.expedia.exercise.dao.offer;

import com.expedia.exercise.config.ExpediaServiceConfig;
import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.offer.OfferResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


/**
 *
 */
@Component
public class OffersDaoImpl implements IOffersDao {

    @Autowired
    private ExpediaServiceConfig expediaServiceConfig;
    private final static Logger LOGGER = LoggerFactory.getLogger(OffersDaoImpl.class);

    public Optional<OfferResponse> getOffers(final OffersRequest offersRequest) {
        final URI offerServiceUri = generateURI(expediaServiceConfig.getOffersUrl(), OfferParamsGenerator.generateParams(offersRequest));
        if(offerServiceUri == null) {
            return Optional.empty();
        }
        try {
            final HttpResponse response = executeOfferRequest(offerServiceUri);
            final int httpResponseCode = response.getStatusLine().getStatusCode();
            final String body = new BasicResponseHandler().handleResponse(response);
            if(httpResponseCode != 200) {
                LOGGER.error(String.format("Not success HTTP response %s from offer url: %s, body:\n%s\n", httpResponseCode, expediaServiceConfig.getOffersUrl(), body));
                return Optional.empty();
            }
            return getOfferResponse(body);
        } catch (IOException e) {
            LOGGER.error(String.format("Connection issue can't make a request for url: %s", offerServiceUri.toString()) ,e);
        }
        return Optional.empty();
    }

    /**
     * It will convert json response to Pojo
     * @param body
     * @return
     * @throws IOException
     */
    private Optional<OfferResponse> getOfferResponse(String body) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Optional.of(mapper.readValue(body, OfferResponse.class));
    }

    /**
     * It will execute the request
     * @param offerServiceUri
     * @return
     * @throws IOException
     */
    private HttpResponse executeOfferRequest(URI offerServiceUri) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(offerServiceUri);
        return client.execute(httpGet);
    }

    /**
     *
     * @param url
     * @param params
     * @return
     */
    protected static URI generateURI(final String url, final List <NameValuePair> params)  {
        try {
            return new URIBuilder(url)
                    .setParameters(params)
                    .build();
        }catch (URISyntaxException e){
            LOGGER.error("Error on building URI Offer Service for url: " + url, e);
        }
        return null;
    }

}
