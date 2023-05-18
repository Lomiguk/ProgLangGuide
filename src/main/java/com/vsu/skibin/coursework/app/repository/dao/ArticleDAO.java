package com.vsu.skibin.coursework.app.repository.dao;

import com.vsu.skibin.coursework.app.api.data.dto.ArticleDTO;
import com.vsu.skibin.coursework.app.repository.rowMapper.ArticleDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArticleDAO {
    private final String GET_ARTICLE_QUERY = "SELECT title, author_id, post_date, content, read_count FROM article WHERE id = ?;";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArticleDTO getArticle(Long id) {
        return jdbcTemplate.query(GET_ARTICLE_QUERY, new ArticleDTORowMapper(), id).stream().findAny().orElse(null);
    }
}
