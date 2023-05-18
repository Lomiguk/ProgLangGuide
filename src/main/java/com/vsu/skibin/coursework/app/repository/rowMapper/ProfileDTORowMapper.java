package com.vsu.skibin.coursework.app.repository.rowMapper;

import com.vsu.skibin.coursework.app.api.data.dto.ProfileDTO;
import com.vsu.skibin.coursework.app.exception.rowMapper.RowMapException;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDTORowMapper implements RowMapper<ProfileDTO> {
    @Override
    public ProfileDTO mapRow(ResultSet rs, int rowNum) {
        try {
            return ProfileDTO.builder()
                    .login(rs.getString("login"))
                    .email(rs.getString("email"))
                    .isAuthor(rs.getBoolean("is_author"))
                    .build();
        } catch (SQLException e) {
            throw new RowMapException("ProfileDTO map exception");
        }
    }
}
