/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.defacto.DAO.impl;

import com.mohit.defacto.DAO.AuthorDAO;
import com.mohit.defacto.entity.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value = "authorDao")
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Author author) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO author(author_name,address,mobile_number,email,status)" + "VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[] {
            author.getAuthorName(),
            author.getAddress(),
            author.getMobileNumber(),
            author.getEmail(),
            author.isStatus()
        });
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM author WHERE author_id=?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }

    @Override
    public int update(Author author) throws SQLException, ClassNotFoundException {
        String sql="UPDATE author SET author_name=?,SET address=?,SET mobile_number=?,SET email=?,SET status=? WHERE author_id=?";
        return jdbcTemplate.update(sql, new Object[]{
            author.getAuthorName(),
            author.getAddress(),
            author.getMobileNumber(),
            author.getEmail(),
            author.isStatus(),
            author.getAuthorId()
        });
    }

    @Override
    public List<Author> getAll(boolean status) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM author WHERE 1=1 ";
        
        if(status){
            sql+=" AND status=1";
        }
        
        return jdbcTemplate.query(sql, new RowMapper<Author>() {

            @Override
            public Author mapRow(ResultSet rs, int i) throws SQLException {
                Author author=new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setAddress(rs.getString("address"));
                author.setMobileNumber(rs.getString("mobile_number"));
                author.setEmail(rs.getString("email"));
                return author;
            }
        });
        
    }

    @Override
    public Author getById(int id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM author WHERE author_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new RowMapper<Author>() {

            @Override
            public Author mapRow(ResultSet rs, int i) throws SQLException {
                 Author author=new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setAddress(rs.getString("address"));
                author.setMobileNumber(rs.getString("mobile_number"));
                author.setEmail(rs.getString("email"));
                return author;
            }
        });
    }

}
