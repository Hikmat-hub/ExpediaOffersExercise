
package com.expedia.exercise.pojo.response.offer;


import lombok.Data;

/**
 * The Userinfo Schema
 * <p>
 * 
 * 
 */
@Data
public class UserInfo {

    /**
     * The Persona Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public Persona persona;
    /**
     * The Userid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    public String userId = "";

}
