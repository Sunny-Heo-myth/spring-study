package org.alan.toby.chapterone.exampleDomain.query;

public interface UserQuery {
    String INSERT = "insert into users(id, name, password) values (?,?,?)";
    String FIND = "select * from users where id = ?";
    String DELETE_ALL = "delete from users";
}
