package com.sy.example.core.service;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    boolean checkToken(String userName, String token);
}
