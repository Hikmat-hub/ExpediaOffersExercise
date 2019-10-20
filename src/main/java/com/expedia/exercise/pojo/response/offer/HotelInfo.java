
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Hotelinfo Schema
 * <p>
 * 
 * 
 */
@Data
public class HotelInfo {

    /**
     * The Hotelid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelId = "";
    /**
     * The Hotelname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelName = "";
    /**
     * The Localizedhotelname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String localizedHotelName = "";
    /**
     * The Hoteldestination Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelDestination = "";
    /**
     * The Hoteldestinationregionid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelDestinationRegionID = "";
    /**
     * The Hotellongdestination Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelLongDestination = "";
    /**
     * The Hotelstreetaddress Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelStreetAddress = "";
    /**
     * The Hotelcity Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelCity = "";
    /**
     * The Hotelprovince Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelProvince = "";
    /**
     * The Hotelcountrycode Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelCountryCode = "";
    /**
     * The Hotellatitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double hotelLatitude = 0.0D;
    /**
     * The Hotellongitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double hotelLongitude = 0.0D;
    /**
     * The Hotelstarrating Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelStarRating = "";
    /**
     * The Hotelguestreviewrating Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double hotelGuestReviewRating = 0.0D;
    /**
     * The Hotelreviewtotal Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Integer hotelReviewTotal = 0;
    /**
     * The Hotelimageurl Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String hotelImageUrl = "";
    /**
     * The Vipaccess Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Boolean vipAccess = false;
    /**
     * The Isofficialrating Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Boolean isOfficialRating = false;

}
