create table if not exists user (
	id bigint AUTO_INCREMENT primary key,
	name varchar(64) not null,
	email varchar(128),
	hash_password varchar(255)
);