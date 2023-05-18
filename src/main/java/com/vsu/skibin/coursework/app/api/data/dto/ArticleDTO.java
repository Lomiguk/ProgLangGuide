package com.vsu.skibin.coursework.app.api.data.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ArticleDTO {
    private String title;
    private Long authorId;
    private Timestamp date;
    private String content;
    private Integer readCount;
}
