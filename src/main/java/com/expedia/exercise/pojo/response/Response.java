package com.expedia.exercise.pojo.response;

import lombok.Data;

@Data
public abstract class Response {

    public enum Status {
        ERROR, SUCCESS
    }

    private Status status;
}
