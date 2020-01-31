package com.sy.example.core.convertor;

import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;

public class UserDTOConvertor {

    public static class Builder {

        private User user = new User();

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public UserDTO loginBuild(String token) {
            UserDTO userDTO = null;
            if(user != null) {
                userDTO = new UserDTO(user.getName(), token);
            }
            return userDTO;
        }

        public UserDTO userInfoBuild(String token) {
            UserDTO userDTO = null;
            if(user != null) {
                userDTO = new UserDTO(user.getName(), user.getPhone(), token, user.getRoles(), user.getIntroduction(), user.getAvatar());
            }
            return userDTO;
        }

    }

    public static UserDTOConvertor.Builder newBuilder() {
        return new Builder();
    }
}
