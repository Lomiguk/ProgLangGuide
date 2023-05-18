package com.vsu.skibin.coursework.app.entity;

import lombok.Data;

@Data
public class Profile {
    private Long id;
    private char[] email;
    private String login;
    private String password;
    private boolean isAuthor;
}
