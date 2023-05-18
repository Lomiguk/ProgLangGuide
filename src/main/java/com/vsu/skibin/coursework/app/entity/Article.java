package com.vsu.skibin.coursework.app.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Article {
    private Long id;
    private String title;
    private Long authorId;
    private Date postDate;
    private String content;
    private Integer readCount;
}
