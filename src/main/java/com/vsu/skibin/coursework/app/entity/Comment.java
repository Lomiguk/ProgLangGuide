package com.vsu.skibin.coursework.app.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private Long id;
    private Long authorId;
    private Long articleId;
    private String content;
    private Date postDate;
}
