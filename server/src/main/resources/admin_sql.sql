create table admin_roles
(
	user_id bigint not null,
	role_id bigint not null,
	primary key (user_id, role_id)
)
engine=InnoDB
;

create index FK3liyab508sfblqps0eqjhmjqk
	on admin_roles (role_id)
;

create table admins
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	cell varchar(11) null,
	company_code varchar(255) null,
	company_name varchar(20) null,
	email varchar(40) null,
	password varchar(100) null,
	phone varchar(11) null,
	user_name varchar(40) null,
	constraint UK47bvqemyk6vlm0w7crc3opdd4
		unique (email)
)
engine=InnoDB
;

alter table admin_roles
	add constraint FK736upcx9vmuarxov7plm7vm4c
		foreign key (user_id) references admins (id)
;

create table campsite
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	address varchar(45) null,
	bankbook_settle bit not null,
	business_number varchar(40) null,
	cell varchar(45) null,
	company_code varchar(255) null,
	company_name varchar(45) null,
	end_date varchar(10) null,
	image varchar(255) null,
	latitude bigint not null,
	longitude bigint not null,
	offline_card_settle bit not null,
	offline_cash_settle bit not null,
	online_settle bit not null,
	phone varchar(45) null,
	season_used bit not null,
	start_date varchar(10) null,
	street varchar(45) null,
	sub_image1 varchar(255) null,
	sub_image2 varchar(255) null,
	sub_image3 varchar(255) null
)
engine=InnoDB
;

create table campsite_facilities
(
	campsite_no bigint not null,
	facilitie_no bigint not null,
	constraint FK59r9re6v7f63wh0v6pe70imnj
		foreign key (campsite_no) references campsite (id)
)
engine=InnoDB
;

create index FK59r9re6v7f63wh0v6pe70imnj
	on campsite_facilities (campsite_no)
;

create index FK7sfm7igogajepj9jbl30cq1h5
	on campsite_facilities (facilitie_no)
;

create table category
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	name varchar(255) null
)
engine=InnoDB
;

create table facilitie
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	name varchar(255) null
)
engine=InnoDB
;

alter table campsite_facilities
	add constraint FK7sfm7igogajepj9jbl30cq1h5
		foreign key (facilitie_no) references facilitie (id)
;

create table roles
(
	id bigint auto_increment
		primary key,
	name varchar(60) null,
	constraint UK_nb4h0p6txrmfc0xbrd1kglp9t
		unique (name)
)
engine=InnoDB
;

alter table admin_roles
	add constraint FK3liyab508sfblqps0eqjhmjqk
		foreign key (role_id) references roles (id)
;

create table season
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	end_date varchar(10) null,
	season_type varchar(1) null,
	start_date varchar(10) null,
	campsite_id bigint null,
	constraint FKr3hii1gsvv1vkrpkq2nixhyaq
		foreign key (campsite_id) references campsite (id)
)
engine=InnoDB
;

create index FKr3hii1gsvv1vkrpkq2nixhyaq
	on season (campsite_id)
;

create table site
(
	id bigint auto_increment
		primary key,
	created_at datetime not null,
	updated_at datetime not null,
	allowed_people int not null,
	barcode varchar(20) null,
	campsite_id bigint null,
	category_id bigint not null,
	name varchar(45) null,
	site_count int not null,
	weekday_default_price int not null,
	weekday_higher_season_price int not null,
	weekday_season_price int not null,
	weekend_default_price int not null,
	weekend_higher_season_price int not null,
	weekend_season_price int not null,
	constraint FKfy5r7tgwvo188wktqso11rfei
		foreign key (campsite_id) references campsite (id)
)
engine=InnoDB
;

create index FKfy5r7tgwvo188wktqso11rfei
	on site (campsite_id)
;

create table site_category
(
	site_no bigint not null,
	category_no bigint not null,
	constraint FKmwlp138ug2c0vpsr0whm7f2j6
		foreign key (site_no) references site (id),
	constraint FK3e8rhit6rm4qcgoi6wuvwrae2
		foreign key (category_no) references category (id)
)
engine=InnoDB
;

create index FKmwlp138ug2c0vpsr0whm7f2j6
	on site_category (site_no)
;

create index FK3e8rhit6rm4qcgoi6wuvwrae2
	on site_category (category_no)
;


-- 시큐리티 권한
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
