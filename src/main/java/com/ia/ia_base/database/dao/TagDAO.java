package com.ia.ia_base.database.dao;

import com.ia.ia_base.models.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TagDAO extends BaseDAO<Tag>{

    public List<Tag> findAll() throws SQLException {
        String sql = "SELECT * from tags";
        return executeQuery(sql);
    }

    public Tag findById(int id) throws SQLException {
        String sql = "SELECT * FROM tags WHERE id = ?";
        List<Tag> results = executeQuery(sql, id);
        return results.isEmpty() ? null : results.getFirst();
    }

    public Tag findByTag(String question) throws SQLException {
        String sql = "SELECT * FROM tags WHERE tagName = ?";
        List<Tag> results = executeQuery(sql, question);
        return results.isEmpty() ? null : results.getFirst();
    }

    public int create(Tag entity) throws SQLException {
        String sql = "INSERT INTO tags (tagName) VALUES (?)";
        return executeUpdate(sql, entity.getTagName());
    }

    public int update(Tag entity) throws SQLException {
        String sql = "UPDATE tags SET tagName = ? WHERE id = ?";
        return executeUpdate(sql, entity.getTagName());
    }

    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM tags WHERE id = ?";
        return executeUpdate(sql, id);
    }

    @Override
    protected Tag mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Tag(rs.getString("tagName"));
    }
}
