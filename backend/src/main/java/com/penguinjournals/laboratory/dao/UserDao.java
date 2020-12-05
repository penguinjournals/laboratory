package com.penguinjournals.laboratory.dao;

import com.penguinjournals.laboratory.domain.Role;
import com.penguinjournals.laboratory.domain.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.penguinjournals.laboratory.jooq.tables.UserData.USER_DATA;
import static com.penguinjournals.laboratory.jooq.tables.UserRole.USER_ROLE;
import static com.penguinjournals.laboratory.jooq.tables.Role.ROLE;

@Component
public class UserDao {

    private DSLContext dslContext;

    public UserDao(final DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Optional<User> findUserByName(final String username) {
        Optional<User> user = getDsl()
                .select()
                .from(USER_DATA)
                .where(USER_DATA.NAME.eq(username))
                .fetchOptionalInto(User.class);

        if (user.isPresent()) {
            List<Role> userRoles = getDsl()
                    .select(ROLE.ID, ROLE.NAME)
                    .from(USER_DATA)
                    .join(USER_ROLE).on(USER_DATA.ID.eq(USER_ROLE.ID_USER_DATA))
                    .join(ROLE).on(USER_ROLE.ID_ROLE.eq(ROLE.ID))
                    .where(USER_DATA.NAME.eq(user.get().getName()))
                    .fetchInto(Role.class);
            user.get().setRoles(userRoles);
        }
        return user;
    }

    public Optional<User> findUserByEmail(final String email) {
        return getDsl()
                .select()
                .from(USER_DATA)
                .where(USER_DATA.EMAIL.eq(email))
                .fetchOptionalInto(User.class);
    }

    public void insertUserWithRoles(final User user) {
        Long userId = getDsl()
                .insertInto(USER_DATA)
                .set(USER_DATA.NAME, user.getName())
                .set(USER_DATA.EMAIL, user.getEmail())
                .set(USER_DATA.PASSWORD, user.getPassword())
                .onConflictDoNothing()
                .returning(USER_DATA.ID)
                .fetchOne()
                .getValue(USER_DATA.ID);
        if (userId != null) {
            for (Role role : user.getRoles()) {
                getDsl()
                        .insertInto(USER_ROLE)
                        .set(USER_ROLE.ID_ROLE, role.getId())
                        .set(USER_ROLE.ID_USER_DATA, userId)
                        .execute();
            }
        }
    }

    private DSLContext getDsl() {
        return this.dslContext;
    }
}
