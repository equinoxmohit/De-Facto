/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.defacto.DAO;

import com.mohit.defacto.entity.Author;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface AuthorDAO {

    int insert(Author author) throws SQLException, ClassNotFoundException;

    int delete(int id) throws SQLException, ClassNotFoundException;

    int update(Author author) throws SQLException, ClassNotFoundException;

    List<Author> getAll(boolean status) throws SQLException, ClassNotFoundException;

    Author getById(int id) throws SQLException, ClassNotFoundException;
}
