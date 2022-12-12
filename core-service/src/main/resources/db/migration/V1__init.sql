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

insert into categories (title)
values  ('Food'),
        ('Electronic');

insert into products (title, price, category_id)
values
    ('Bread', 32.1, 1),
    ('Milk', 120.1, 1),
    ('Butter', 320.1, 1),
    ('Cheese', 500.1, 1);

create table orders
(
    id              bigserial primary key,
    username        varchar(255),
    total_price     int,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

create table orders_items
(
    id                      bigserial primary key,
    order_id                bigint references orders (id),
    product_id              bigint references products (id),
    price_per_product       int,
    quantity                int,
    price                   int,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);

insert into orders (username, total_price)
values ('Alex', 32.1),
       ('Bob', 240.2);

insert into orders_items (order_id, product_id,  price_per_product, quantity, price)
values (1, 1, 32.1, 1, 32.1),
       (2, 2, 120.1, 2, 240.2);