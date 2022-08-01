package com.ust.util.users.dao;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.ust.util.users.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//controller

// Contains methods to Read and write from the DB
// Repository is data access layer
@Repository("UsersRepository") // User Repository is a class that contains the methods for executing CRUD operations
// User Repository
public class JDBCUsersRepository implements UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final List<Users> users = new ArrayList<>();

    @Override
    public int insertUsers(int id, Users users) {
    String sql = "INSERT INTO USERS(UNAME, PW) VALUES (?,?)"; // sql command that it is going to send to SQL DB telling it to insert this record. '
        // '? ' is a placekeeper and it is going to replaced by a value & that value
     return jdbcTemplate.update(sql,
       new Object[]{ users.getUname(), users.getPw()});} // '?' -> user.getUname() // new Object[] -> new json object

    @Override
    public int updateUsers(int id, Users users) {
        String sql = "UPDATE USERS SET UNAME=?, PW=? WHERE id=?"; // update the records;
        return jdbcTemplate.update(sql,
          new Object[]{ users.getUname(), users.getPw(), id});
    }

    @Override
    public int deleteUsers(int id) {
        String sql = "DELETE FROM USERS WHERE ID=?";
        return jdbcTemplate.update(sql, id);
    }

//    @Override
//    public List<Users> queryUsers() {
//        String sql = "SELECT * FROM USERS SET UNAME=?, PWORD=? WHERE id=?";
//        return jdbcTemplate.query(sql,
//                BeanPropertyRowMapper.newInstance(Users.class));
//    }
    @Override
    public List<Users> queryUsers() {
        String sql = "SELECT * FROM USERS ";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Users.class));
            }
    @Override
    public Users validateLogin(String uname, String pw) {
        String sql = "select uname, pw from users WHERE uname=? ";
      Users users = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Users.class), uname);
      if(users != null){
          if(users.getPw().equals(pw)){
              return users;
          }
      }
      return new Users(0,"no match","nomatch"); }

    @Override
    public Optional<Users> queryUsers(int id) {
        Users users = null;
        try {
            String sql = "SELECT * FROM USERS WHERE ID=?";
            users = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(Users.class), id);
            return Optional.ofNullable(users);
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(users);
        }
    }
}
