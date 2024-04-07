package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.model.Author;

public class MapperAuthor implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        
        author.setId(rs.getInt("id"));
        
        author.setName(rs.getString("name"));
        
        author.setCreatedDate(rs.getTimestamp("createdDate"));
        author.setModifiedDate(rs.getTimestamp("modifiedDate"));
        author.setCreatedBy(rs.getString("createdBy"));
        author.setModifiedBy(rs.getString("modifiedBy"));
        
        return author;
    }
}