package com.vsu.skibin.coursework.app.api.data.request;

import lombok.Data;

@Data
public class DoublePasswordRequest {
    String oldPassword;
    String newPassword;
}
