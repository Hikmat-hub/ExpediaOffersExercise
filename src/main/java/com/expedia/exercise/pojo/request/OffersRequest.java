package com.expedia.exercise.pojo.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Fields name should be the same name of offer service query param
 */
@Data
public class OffersRequest {

    private String destinationName;
    private List<String> regionIds;
    private Date minTripStartDate;
    private Date maxTripStartDate;
    private Integer lengthOfStay;
    private Byte maxStarRating;
    private Byte minStarRating;
    private Byte maxTotalRate;
    private Byte minTotalRate;
    private Byte maxGuestRating;
    private Byte minGuestRating;

    @JsonGetter("regionIds")
    public String getRegionIds() {
        if(this.regionIds == null){
            return null;
        }
        return String.join(",", this.regionIds);
    }
}
