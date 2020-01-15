package com.sy.example.comm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultEntity<T> {

    private int code;
    private String message;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultEntity(HttpStatus httpStatus, T data) {
        this.code = httpStatus.getStatus();
        this.message = httpStatus.getMessage();
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
