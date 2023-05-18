package com.vsu.skibin.coursework.app.api.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProfileDTO {
    private String email;
    private String login;
    private boolean isAuthor;
}
