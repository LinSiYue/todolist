package com.sy.example.comm.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HttpStatus {
    private int status;
    private String message;

    public HttpStatus() {
    }

    public HttpStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpStatus{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
