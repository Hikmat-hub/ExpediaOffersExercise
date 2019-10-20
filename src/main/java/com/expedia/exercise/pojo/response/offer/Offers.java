
package com.expedia.exercise.pojo.response.offer;

import lombok.Data;

import java.util.List;


/**
 * The Offers Schema
 * <p>
 * 
 * 
 */
@Data
public class Offers {

    /**
     * The Hotel Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public List<Hotel> hotel = null;

}
