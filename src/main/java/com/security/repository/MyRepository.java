package com.security.repository;

import com.security.model.User;
import com.security.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;


//    Создаём
    public void addSave(User addUser) {
        String sql = "INSERT INTO usergood (username, password) VALUES (?,?)";
        jdbcTemplate.update(sql, addUser.getUsername(), addUser.getPassword());
    }

    public User getByUsername(String username) {
        String sql = "SELECT * FROM usergood WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
    }
}
