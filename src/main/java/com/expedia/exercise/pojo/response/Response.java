package com.expedia.exercise.pojo.response;

public abstract class Response {

    public enum Status {
        ERROR, SUCCESS
    }

    private Status status;
}
