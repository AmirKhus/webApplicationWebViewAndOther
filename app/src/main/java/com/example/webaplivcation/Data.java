package com.example.webaplivcation;

import lombok.Getter;
import lombok.Setter;

public class Data {
    @Getter
    @Setter
    private String login;

    public Data(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
