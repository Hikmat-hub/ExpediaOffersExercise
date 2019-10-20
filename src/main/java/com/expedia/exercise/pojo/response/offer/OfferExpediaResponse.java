
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Root Schema
 * <p>
 * 
 * 
 */
@Data
public class OfferExpediaResponse {

    /**
     * The Offerinfo Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public OfferInfo offerInfo;
    /**
     * The Userinfo Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public UserInfo userInfo;
    /**
     * The Abinfo Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public AbInfo abInfo;
    /**
     * The Offers Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Offers offers;

}
