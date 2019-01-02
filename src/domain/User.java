package domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
    private String username;
    private String password;
/*按alt+insert快捷键*/
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
