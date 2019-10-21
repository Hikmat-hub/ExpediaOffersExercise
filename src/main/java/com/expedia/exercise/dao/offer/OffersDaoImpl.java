package com.expedia.exercise.dao.offer;

import com.expedia.exercise.config.ExpediaServiceConfig;
import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.offer.OfferExpediaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 *
 */
@Component
public class OffersDaoImpl implements IOffersDao {

    @Autowired
    private ExpediaServiceConfig expediaServiceConfig;
    private final static Logger LOGGER = LoggerFactory.getLogger(OffersDaoImpl.class);

    public Optional<OfferExpediaResponse> getOffers(final OffersRequest offersRequest) {
        final URI offerServiceUri = generateURI(expediaServiceConfig.getOffersUrl(), OfferParamsGenerator.generateParams(offersRequest));
        if(offerServiceUri == null) {
            return Optional.empty();
        }

        try {
            final HttpResponse response = executeOfferRequest(offerServiceUri);
            final int httpResponseCode = response.getStatusLine().getStatusCode();
            final String body = EntityUtils.toString(response.getEntity());
            if(httpResponseCode != 200) {
                LOGGER.error(String.format("Not success HTTP response %s from offer url: %s.", httpResponseCode, expediaServiceConfig.getOffersUrl()));
                return Optional.empty();
            }
            return getOfferResponse(body);
        } catch (IOException e) {
            LOGGER.error(String.format("Connection issue can't make a request for url: %s", offerServiceUri.toString()) ,e);
        } catch (ParseException e){
            LOGGER.error(String.format("Can't parse HTTP response from offer url: %s", offerServiceUri.toString()), e);
            return Optional.empty();
        }
        return Optional.empty();
    }

    /**
     * It will convert json response to Pojo
     * @param body
     * @return
     * @throws IOException
     */
    private Optional<OfferExpediaResponse> getOfferResponse(String body) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Optional.of(mapper.readValue(body, OfferExpediaResponse.class));
    }

    /**
     * It will execute the request
     * @param offerServiceUri
     * @return
     * @throws IOException
     */
    private HttpResponse executeOfferRequest(URI offerServiceUri) throws IOException {

//        HttpURLConnection conn = (HttpURLConnection) offerServiceUri.toURL().openConnection();
//        conn.setRequestMethod("GET");
////        conn.setRequestProperty("Accept", "application/json");
//        conn.setRequestProperty(HttpHeaders.USER_AGENT, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
//        conn.setRequestProperty(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
//        conn.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
//        conn.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");
//        conn.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
//        conn.setRequestProperty(HttpHeaders.CONNECTION, "keep-alive");
//        conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
//        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        final String collect = br.lines().collect(Collectors.joining());
//        System.out.println(collect);

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .setDefaultHeaders(Arrays.asList())
                .build();

//                new DecompressingHttpClient(new DefaultHttpClient());
        HttpGet httpGet = new HttpGet(offerServiceUri);
        addBrowserHeaders(httpGet);
        Arrays.stream(httpGet.getAllHeaders()).forEach(header -> LOGGER.warn(header.getName()+"--> " + header.getValue()));
        return httpClient.execute(httpGet);
    }

    /**
     * It will add browser header to prevent to many request response
     * @param httpGet
     */
    private void addBrowserHeaders(HttpGet httpGet) {
        httpGet.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        httpGet.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        httpGet.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        httpGet.setHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");
        httpGet.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        httpGet.setHeader(HttpHeaders.CONNECTION, "keep-alive");
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
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
