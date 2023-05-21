package com.vsu.skibin.coursework.app.api.data.request.article;

import lombok.Data;

@Data
public class PatchArticleRequest {
    private String tittle;
    private String content;
}
