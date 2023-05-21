package com.vsu.skibin.coursework.app.api.data.request.article;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AddArticleRequest {
    private String title;
    private Timestamp date;
    private String content;
}
