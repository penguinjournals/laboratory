package com.penguinjournals.laboratory.dao;

import com.penguinjournals.laboratory.domain.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.penguinjournals.laboratory.jooq.tables.UserData.USER_DATA;

@Component
public class UserDao {

    private DSLContext dslContext;

    public UserDao(final DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    private DSLContext getDsl() {
        return this.getDsl();
    }

    public Optional<User> findUserByName(final String username) {
        return getDsl()
                .select()
                .from(USER_DATA)
                .where(USER_DATA.NAME.eq(username))
                .fetchOptionalInto(User.class);
    }

    public Optional<User> findUserByEmail(final String email) {
        return getDsl()
                .select()
                .from(USER_DATA)
                .where(USER_DATA.EMAIL.eq(email))
                .fetchOptionalInto(User.class);
    }
}
