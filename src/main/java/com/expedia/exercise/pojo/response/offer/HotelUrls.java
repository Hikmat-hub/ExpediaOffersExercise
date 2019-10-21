
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * The Hotelurls Schema
 * <p>
 * 
 * 
 */
@Data
public class HotelUrls {

    /**
     * The Hotelinfositeurl Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelInfositeUrl = "";
    /**
     * The Hotelsearchresulturl Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelSearchResultUrl = "";

    public String getHotelInfositeUrl(){
        if(this.hotelInfositeUrl == null){
            return null;
        }
        try {
            return URLDecoder.decode(this.hotelInfositeUrl, StandardCharsets.UTF_8.toString());
        }catch (Exception e){
        }
        return null;
    }

}
