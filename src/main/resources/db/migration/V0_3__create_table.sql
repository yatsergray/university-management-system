create table degrees
(
    id   uuid         not null,
    name varchar(255) not null unique,
    type varchar(255) not null unique check (type in ('ASSISTANT', 'ASSOCIATE_PROFESSOR', 'PROFESSOR')),
    primary key (id)
);

create table lectors
(
    id         uuid           not null,
    salary     numeric(19, 2) not null,
    degree_id  uuid           not null,
    first_name varchar(255)   not null,
    last_name  varchar(255)   not null,
    primary key (id)
);

create table departments
(
    id      uuid         not null,
    head_id uuid         not null,
    name    varchar(255) not null unique,
    primary key (id)
);

create table department_lectors
(
    department_id uuid not null,
    lector_id     uuid not null,
    primary key (department_id, lector_id)
);
