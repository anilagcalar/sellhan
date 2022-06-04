create table public.t_admin(
	id bigint not null,
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255)
	
);
 create table public.t_customer(
 	id bigint not null,
 	first_name varchar(255),
 	last_name varchar(255),
 	email varchar(255)
 	
 
 );


 alter table public.t_admin add constraint public.constraint_1 primary key(id);
 
 alter table public.t_customer add constraint public.constraint_2 primary key(id);
 
 create sequence public.sellhan_sequence start with 100;
 
 