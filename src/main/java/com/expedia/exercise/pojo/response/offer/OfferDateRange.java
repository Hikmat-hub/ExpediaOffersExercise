
package com.expedia.exercise.pojo.response.offer;

import lombok.Data;

import java.util.List;


/**
 * The Offerdaterange Schema
 * <p>
 * 
 * 
 */
@Data
public class OfferDateRange {

    /**
     * The Travelstartdate Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public List<Integer> travelStartDate = null;
    /**
     * The Travelenddate Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public List<Integer> travelEndDate = null;
    /**
     * The Lengthofstay Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Integer lengthOfStay = 0;

}
