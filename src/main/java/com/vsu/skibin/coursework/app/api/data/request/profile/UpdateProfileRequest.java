package com.vsu.skibin.coursework.app.api.data.request.profile;

import com.vsu.skibin.coursework.app.tool.PasswordUtil;
import lombok.Data;

@Data
public class UpdateProfileRequest {
    private String login;
    private String email;
    private boolean isAuthor;
    private Long password;

    public UpdateProfileRequest(String login, String email, boolean is_author, String password) {
        this.login = login;
        this.email = email;
        this.isAuthor = is_author;
        this.password = PasswordUtil.getHash(password);
    }
}
