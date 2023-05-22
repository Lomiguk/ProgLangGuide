package com.vsu.skibin.coursework.app.repository.dao;

import com.vsu.skibin.coursework.app.api.data.dto.ArticleDTO;
import com.vsu.skibin.coursework.app.repository.rowMapper.ArticleDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ArticleDAO {
    private final String GET_ARTICLE_QUERY = "SELECT title, author_id, post_date, content, read_count FROM article WHERE id = ?;";
    private final String ADD_ARTICLE_QUERY = "INSERT INTO article (author_id, title, post_date, content, read_count) VALUES (?, ?, ?, ?, 0);";
    private final String UPDATE_ARTICLE_QUERY = "UPDATE article SET title = ?, content = ? WHERE id = ?;";
    private final String DELETE_ARTICLE_QUERY = "DELETE FROM article WHERE id = ?;";
    private final String INC_COUNT_QUERY = "UPDATE article SET read_count = read_count + 1 WHERE id = ?;";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArticleDTO getArticle(Long id) {
        return jdbcTemplate.query(GET_ARTICLE_QUERY, new ArticleDTORowMapper(), id).stream().findAny().orElse(null);
    }

    public int addArticle(Long authorId, String title, Timestamp date, String content) {
        return jdbcTemplate.update(ADD_ARTICLE_QUERY, authorId, title, date, content);
    }

    public int updateArticle(Long id, String tittle, String content) {
        return jdbcTemplate.update(UPDATE_ARTICLE_QUERY, tittle, content, id);
    }
    public int deleteArticle(Long id) {
        return jdbcTemplate.update(DELETE_ARTICLE_QUERY, id);
    }
    public int incReadCount(Long id) {
        return jdbcTemplate.update(INC_COUNT_QUERY, id);
    }
}
