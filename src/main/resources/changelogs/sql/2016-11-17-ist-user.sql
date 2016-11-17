--liquibase formatted sql

--chageset istomin:create_user_table
create table user (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(50),
  password VARCHAR(50),
  reg_date TIMESTAMP(14),
  email VARCHAR(50)
)
--rollback drop table user