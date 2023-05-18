package com.vsu.skibin.coursework.app.api.data.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String login;
    private String password;
}
