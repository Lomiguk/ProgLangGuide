package com.vsu.skibin.coursework.app.service;

import com.vsu.skibin.coursework.app.api.data.dto.ArticleDTO;
import com.vsu.skibin.coursework.app.repository.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleDAO articleDAO;

    @Autowired
    public ArticleService(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    public ArticleDTO getArticle(Long id) {
        return articleDAO.getArticle(id);
    }
}
