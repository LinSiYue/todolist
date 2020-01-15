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

        public UserDTO loginBuild() {
            UserDTO userDTO = null;
            if(user != null) {
                userDTO = new UserDTO(user.getName(), "editor-token");
            }
            return userDTO;
        }

        public UserDTO userInfoBuild() {
            UserDTO userDTO = null;
            if(user != null) {
                userDTO = new UserDTO(user.getName(), user.getPhone(), "editor-token", user.getRoles(), user.getIntroduction(), user.getAvatar());
            }
            return userDTO;
        }

    }

    public static UserDTOConvertor.Builder newBuilder() {
        return new Builder();
    }
}
