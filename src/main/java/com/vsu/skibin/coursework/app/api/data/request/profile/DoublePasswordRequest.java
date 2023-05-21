package com.vsu.skibin.coursework.app.api.data.request.profile;

import lombok.Data;

@Data
public class DoublePasswordRequest {
    String oldPassword;
    String newPassword;
}
