
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Hotelpricinginfo Schema
 * <p>
 * 
 * 
 */
@Data
public class HotelPricingInfo {

    /**
     * The Averagepricevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double averagePriceValue = 0.0D;
    /**
     * The Totalpricevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double totalPriceValue = 0.0D;
    /**
     * The Displaypricevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double displayPriceValue = 0.0D;
    /**
     * The Crossoutpricevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double crossOutPriceValue = 0.0D;
    /**
     * The Originalpricepernight Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double originalPricePerNight = 0.0D;
    /**
     * The Originaltotalprice Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double originalTotalPrice = 0.0D;
    /**
     * The Currency Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String currency = "";
    /**
     * The Percentsavings Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Double percentSavings = 0.0D;
    /**
     * The Drr Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Boolean drr = false;

}
