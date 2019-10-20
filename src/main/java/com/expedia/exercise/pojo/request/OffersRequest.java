package com.expedia.exercise.pojo.request;

import com.expedia.exercise.validator.constraint.MinMaxDateConstraint;
import com.expedia.exercise.validator.constraint.PresentFutureDateConstraint;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Fields name should be the same name of offer service query param
 */
@Data
@MinMaxDateConstraint(minDateParameterName = "minTripStartDate", maxDateParameterName = "maxTripStartDate")
public class OffersRequest {

    private String destinationName;
    private List<String> regionIds;
    @PresentFutureDateConstraint(message = "Invalid Min date value, It should equal or grater than current date.")
    private Date minTripStartDate;
    @PresentFutureDateConstraint(message = "Invalid Max date value, It should equal or grater than current date.")
    private Date maxTripStartDate;
    private Integer lengthOfStay;
    private Float maxStarRating;
    private Float minStarRating;
    private Float maxTotalRate;
    private Float minTotalRate;
    private Float maxGuestRating;
    private Float minGuestRating;

    @JsonGetter("regionIds")
    public String getRegionIds() {
        if(this.regionIds == null){
            return null;
        }
        return String.join(",", this.regionIds);
    }
}
