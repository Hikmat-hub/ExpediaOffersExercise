
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Items Schema
 * <p>
 * 
 * 
 */
@Data
public class Hotel {

    /**
     * The Offerdaterange Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public OfferDateRange offerDateRange;
    /**
     * The Destination Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Destination destination;
    /**
     * The Displaydestinationalternativeisavailable Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Boolean displayDestinationAlternativeIsAvailable = false;
    /**
     * The Hotelinfo Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public HotelInfo hotelInfo;
    /**
     * The Hotelpricinginfo Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public HotelPricingInfo hotelPricingInfo;
    /**
     * The Hotelurls Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public HotelUrls hotelUrls;

}
