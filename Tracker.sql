drop database if exists tracker;

create database tracker;
use tracker;

create table user_data
(
	user_id int auto_increment,
    username varchar(255) unique,
    user_password varchar(255),
    primary key (user_id)
);

insert into user_data values(null, 'Micha', 'password123');
insert into user_data values(null, 'Alex', 'password124');
insert into user_data values(null, 'Cliff', 'blah187blah');
insert into user_data values(null, 'Met', '321password');
insert into user_data values(null, 'user1', 'password');
insert into user_data values(null, 'user2', 'password');
insert into user_data values(null, 'user3', 'password');
insert into user_data values(null, 'user4', 'password');
insert into user_data values(null, 'user5', 'password');
insert into user_data values(null, 'user6', 'password');

-- select * from user_data;

create table tv_show
(
	show_id int auto_increment,
    title varchar(255),
    episodes integer,
    primary key (show_id)
);

insert into tv_show values(null, 'Good Omens', 6);
insert into tv_show values(null, 'The Flash', 171);
insert into tv_show values(null, 'Fire Force', 24);
insert into tv_show values(null, 'Property Brothers', 182);
insert into tv_show values(null, 'Show1', 31);
insert into tv_show values(null, 'Show2', 61);
insert into tv_show values(null, 'Show3', 12);
insert into tv_show values(null, 'Show4', 37);
insert into tv_show values(null, 'Show5', 83);
insert into tv_show values(null, 'Show6', 124);

create table user_show
(
    user_id int not null,
    show_id int not null,
    last_watched integer,
    primary key (user_id, show_id),
    foreign key (user_id) references user_data(user_id),
    foreign key (show_id) references tv_show(show_id)
);

insert into user_show values(1, 3, 17);
insert into user_show values(1, 1, 6);
insert into user_show values(1, 2, 0);
insert into user_show values(1, 9, 1);
insert into user_show values(2, 2, 1);
insert into user_show values(2, 3, 24);
insert into user_show values(2, 7, 7);
insert into user_show values(2, 10, 2);
insert into user_show values(3, 1, 6);
insert into user_show values(3, 4, 100);
insert into user_show values(3, 7, 3);
insert into user_show values(3, 10, 12);
insert into user_show values(4, 1, 4);
insert into user_show values(4, 4, 143);
insert into user_show values(4, 7, 3);
insert into user_show values(4, 8, 12);

-- select * from user_show;

-- select title, last_watched, episodes from user_show us
-- join tv_show ts
-- on ts.show_id = us.show_id
-- where user_id = 1;









