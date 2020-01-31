package com.sy.example.core.service.impl;

import com.sy.example.comm.utils.RedisUtil;
import com.sy.example.core.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean checkToken(String userName, String token) {
        if (redisUtil.hasKey(userName)) {
            if (redisUtil.get(userName).equals(token)) {
                return true;
            }
        }
        return false;
    }
}
