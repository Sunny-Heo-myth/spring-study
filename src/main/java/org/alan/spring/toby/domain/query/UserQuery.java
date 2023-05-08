package org.alan.spring.toby.domain.query;

public interface UserQuery {
    String INSERT = "insert into users(id, name, password) values (?,?,?)";
    String FIND = "select * from users where id = ?";
}
