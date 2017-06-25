insert into parent (name) values ('Bob');
insert into parent (name) values ('Susan');
insert into parent (name) values ('Peter');

insert into child (name) values ('Johnny');
insert into child (name) values ('Sarah');

insert into child_parent values (1, 1);
insert into child_parent values (1, 2);
insert into child_parent values (2, 1);
insert into child_parent values (2, 2);

insert into toy (name, owner_id) values ('Nerf Gun', 1);
insert into toy (name, owner_id) values ('Toy Car', 1);
insert into toy (name, owner_id) values ('Barbie Doll', 2);
