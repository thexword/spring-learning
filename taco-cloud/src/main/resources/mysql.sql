drop table if exists taco_order;
drop table if exists taco;
drop table if exists ingredient_ref;
drop table if exists ingredient;

create table if not exists taco_order (
    id bigint auto_increment ,
    delivery_name varchar(50) not null ,
    delivery_street varchar(50) not null ,
    delivery_city varchar(50) not null ,
    delivery_state varchar(50) not null ,
    delivery_zip varchar(50) not null ,
    cc_number varchar(16) not null ,
    cc_expiration varchar(5) not null ,
    cc_cvv varchar(3) not null ,
    placed_at DATE not null ,
    primary key (id)
    );

create table if not exists taco (
    id bigint auto_increment,
    name varchar(50) not null ,
    taco_order_id bigint not null ,
    taco_index bigint not null,
    created_at DATE not null ,
    primary key (id)
);

create table if not exists ingredient_ref (
    taco_id bigint not null ,
    ingredient_id varchar(4) not null ,
    ingredient_index bigint not null
);

create table if not exists ingredient (
    id varchar(4) not null ,
    name varchar(25) not null ,
    type varchar(10) not null ,
    primary key (id)
);

insert into ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');

insert into ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');

insert into ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');

insert into ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');

insert into ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');

insert into ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');

insert into ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');

insert into ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');

insert into ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');

insert into ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');