create table user_data (
    id bigserial unique,
    name varchar(20) unique,
    email varchar(50) unique,
    password varchar(100)
);

create table role (
    id bigserial unique,
    name varchar(20)
);

create table user_role (
    id bigserial,
    id_user_data bigint not null,
    id_role bigint not null,
    foreign key (id_user_data) references user_data(id),
    foreign key (id_role) references role(id)
);

INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');
