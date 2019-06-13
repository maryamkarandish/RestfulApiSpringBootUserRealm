drop table realm if exists;

drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1;

create table realm (
     id bigint not null,
      description varchar(255),
      key varchar(255),
      name varchar(255),
      primary key (id)
);

alter table realm add constraint uniqueNameConstraint unique (name);