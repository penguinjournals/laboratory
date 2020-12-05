package com.penguinjournals.laboratory.repository;

import com.penguinjournals.laboratory.dao.UserDao;
import com.penguinjournals.laboratory.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private final UserDao userDao;

    public UserRepository(final UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> findByUsername(final String username) {
        return getUserDao().findUserByName(username);
    }

    public Optional<User> findUserByEmail(final String email) {
        return getUserDao().findUserByEmail(email);
    }

    public Boolean existsByUsername(final String username) {
        if (this.findByUsername(username).isPresent()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean existsByEmail(final String email) {
        if (this.findUserByEmail(email).isPresent()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void save(final User user) {
        this.getUserDao().insertUserWithRoles(user);
    }

    private UserDao getUserDao() {
        return this.userDao;
    }
}
