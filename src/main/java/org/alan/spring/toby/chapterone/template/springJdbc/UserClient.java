package org.alan.spring.toby.chapterone.template.springJdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import toby.exampleDomain.User;

public class UserClient {
    private final JdbcTemplate template;

    public UserClient(JdbcTemplate template) {
        this.template = template;
    }

    public void deleteAll() {
        this.template.update(
                con -> con.prepareStatement("delete from users")
        );
    }

    public void add(User user) {
        this.template.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword()
        );
    }

    public int getCount() {
        return this.template.query(
                con -> con.prepareStatement("select count(*) from users"),
                rs -> {
                    rs.next();
                    return rs.getInt(1);
                });
    }
}
