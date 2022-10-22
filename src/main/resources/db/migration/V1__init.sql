create table categories (
                            id          bigserial primary key,
                            title       varchar(255),
                            created_at  timestamp default current_timestamp,
                            updated_at  timestamp default current_timestamp
);

create table products (
                          id          bigserial primary key,
                          title       varchar(255),
                          price       numeric(8, 2),
                          category_id bigint references categories (id),
                          created_at  timestamp default current_timestamp,
                          updated_at  timestamp default current_timestamp
);

create table users (
                       id         bigserial primary key,
                       username   varchar(36) not null,
                       password   varchar(80) not null,
                       email      varchar(50) unique,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

create table roles (
                       id         bigserial primary key,
                       name       varchar(50) not null,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

create table users_roles (
                             user_id    bigint not null references users (id),
                             role_id    bigint not null references roles (id),
                             created_at timestamp default current_timestamp,
                             updated_at timestamp default current_timestamp,
                             primary key (user_id, role_id)
);

insert into categories (title)
values  ('Food'),
        ('Electronic');

insert into products (title, price, category_id)
values
    ('Bread', 32.00, 1),
    ('Milk', 120.00, 1),
    ('Butter', 320.00, 1),
    ('Cheese', 500.00, 1);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('alex', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'alex@gmail.com'),
       ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);