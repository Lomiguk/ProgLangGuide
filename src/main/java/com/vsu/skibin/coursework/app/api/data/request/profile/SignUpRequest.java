package com.vsu.skibin.coursework.app.api.data.request.profile;

import lombok.Data;

@Data
public class SignUpRequest {
    String login;
    String email;
    String password;
    String passwordRepeat;
}