package com.sy.example.comm.enums;

public enum HttpStatusEnums {

    SUCCESS(20000,"SUCCESS"),
    INPUT_NULL(50001,"INPUT_NULL"),
    INPUT_MISTAKE(5002, "INPUT_MISTAKE"),
    ERROR(10000, "ERROR");

    private int status;
    private String message;

    private HttpStatusEnums(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HttpStatus{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

}
