package com.sy.example.comm.util;

import com.sy.example.comm.entity.HttpStatus;

public class HttpStatusUtil {

    public static HttpStatus SUCCESS = new HttpStatus(20000,"SUCCESS");
    public static HttpStatus INPUT_NULL = new HttpStatus(50001,"INPUT_NULL");
    public static HttpStatus INPUT_MISTAKE = new HttpStatus(5002, "INPUT_MISTAKE");

}
