package com.vsu.skibin.coursework.app.repository.rowMapper;

import com.vsu.skibin.coursework.app.api.data.dto.ArticleDTO;
import com.vsu.skibin.coursework.app.exception.rowMapper.RowMapException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDTORowMapper implements RowMapper<ArticleDTO> {

    @Override
    public ArticleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        try{
            return ArticleDTO.builder()
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .date(rs.getTimestamp("post_date"))
                    .content(rs.getString("content"))
                    .readCount(rs.getInt("read_count"))
                    .build();
        } catch (SQLException e) {
            throw new RowMapException("ArticleDTO map exception");
        }
    }
}
