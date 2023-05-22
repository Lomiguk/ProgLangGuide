package com.vsu.skibin.coursework.app.api.data.request.comment;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AddCommentRequest {
    private Long authorId;
    private String content;
    private Timestamp timestamp;
}
