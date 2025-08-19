set timezone to 'utc';
drop table if exists users;
drop type if exists roles;

create extension if not exists "uuid-ossp";

create table if not exists users (
  id uuid primary key not null default uuid_generate_v4(),
  username varchar(50) not null,
  email varchar(255) unique not null,
  password varchar(255) not null,
  role varchar(10) not null default 'user',
  phone_number varchar(10) unique not null,
  created_at timestamptz default now(),
  updated_at timestamptz default now()
);