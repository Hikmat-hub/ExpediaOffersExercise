
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Offerinfo Schema
 * <p>
 * 
 * 
 */
@Data
public class OfferInfo {

    /**
     * The Siteid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String siteID = "";
    /**
     * The Language Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String language = "";
    /**
     * The Currency Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String currency = "";
    /**
     * The Userselectedcurrency Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String userSelectedCurrency = "";

}
