package com.penguinjournals.laboratory.dao;

import com.penguinjournals.laboratory.domain.Role;
import com.penguinjournals.laboratory.domain.RoleName;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.penguinjournals.laboratory.jooq.tables.Role.ROLE;

@Component
public class RoleDao {
    private DSLContext dslContext;

    public RoleDao(final DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Optional<Role> getRoleByName(final RoleName name) {
        return getDsl()
                .select()
                .from(ROLE)
                .where(ROLE.NAME.eq(name.toString()))
                .fetchOptionalInto(Role.class);
    }

    private DSLContext getDsl() {
        return this.dslContext;
    }
}
