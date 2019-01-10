package com.itlike.web.domain;


import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
    private Integer id;
    private String username;
    private String password;

/*按alt+insert快捷键*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
