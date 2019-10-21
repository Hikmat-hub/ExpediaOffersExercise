package com.expedia.exercise.pojo.request;

import com.expedia.exercise.validator.constraint.MinMaxDateConstraint;
import com.expedia.exercise.validator.constraint.PresentFutureDateConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @PresentFutureDateConstraint(message = "{minTripStartDate}")
    private Date minTripStartDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @PresentFutureDateConstraint(message = "{maxTripStartDate}")
    private Date maxTripStartDate;
    @Min(1)
    private Integer lengthOfStay;
    @Max(5)
    @Min(0)
    private Integer maxStarRating;
    @Max(5)
    @Min(0)
    private Integer minStarRating;
    @Max(5)
    @Min(0)
    private Integer maxTotalRate;
    @Max(5)
    @Min(0)
    private Integer minTotalRate;
    @Max(5)
    @Min(0)
    private Integer maxGuestRating;
    @Max(5)
    @Min(0)
    private Integer minGuestRating;

    @JsonGetter("regionIds")
    public String getRegionIds() {
        if(this.regionIds == null){
            return null;
        }
        return String.join(",", this.regionIds);
    }
}
