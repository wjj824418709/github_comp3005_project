create table book 
(ISBN		varchar(30),
name 		varchar(20),
author 	varchar(20),
genre		varchar(20),
price		decimal(10,2),
numbers	INTEGER,
pages		INTEGER,
p_cut		decimal(5,2) check (p_cut <= 1),
primary key (ISBN));

create table publisher 
(ID					varchar(5),
name 				varchar(20) not null,
address 			varchar(255),
email				varchar(50),
phone				varchar(25),
banking_account		decimal(10,2),
primary key (ID));

create table warehouse 
(ID			varchar(5),
address 	varchar(255),
phone 		varchar(25),
primary key (ID));

create table orders(
order_number		varchar(20),
order_location		varchar(255),
billing_address		varchar(255),
shipping_address	varchar(255),
order_date			DATE,
primary key (order_number));

create table customer(
email				varchar(50),
name				varchar(255),
phone				varchar(25),
billing_address		varchar(255),
shipping_address	varchar(255),
primary key (email));

create table published
(p_ID		varchar(5),
 ISBN		varchar(30),
 primary key(p_ID, ISBN),
 foreign key(p_ID) references publisher on delete cascade,
 foreign key(ISBN) references book on delete cascade)

create table stock_by
(ISBN		varchar(30),
 w_ID		varchar(15),
 s_number	integer,
 primary key(ISBN, w_ID),
 foreign key(ISBN) references book on delete cascade,
 foreign key(w_ID) references warehouse on delete cascade)

create table add_to
(ISBN				varchar(30),
 order_number		varchar(20),
 primary key(ISBN, order_number),
 foreign key(ISBN) references book on delete cascade,
 foreign key(order_number) references orders on delete cascade)

create table placed_by
(order_number		varchar(20),
 c_email			varchar(50),
 primary key(order_number, c_email),
 foreign key(order_number) references orders on delete cascade,
 foreign key(c_email) references customer on delete cascade)

insert into book values ('972-4-17-142110-4', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', '14.99', '10', '0.2');
insert into book values ('985-2-53-447506-2', 'Lolita', 'Vladimir Nabokov', 'Fiction', '13.99', '15', '0.18');
insert into book values ('951-8-07-142356-3', 'Hamlet', 'William Shakespeare', 'Fiction', '19.99', '25', '0.18');
insert into book values ('990-2-07-112360-4', 'David Copperfield', 'Charles Dickens', 'Fiction', '17.99', '15', '0.08');
insert into book values ('932-9-47-145660-8', 'Pride and Prejudice', 'Jane Austen', 'Fiction', '12.99', '10', '0.15');
insert into book values ('984-3-75-468549-9', 'Confessions', 'Augustine', 'Nonfiction', '13.99', '15', '0.17');
insert into book values ('975-4-83-846819-0', 'The Art of War', 'Sun Zi', 'Nonfiction', '10.99', '20', '0.12');
insert into book values ('953-7-75-854649-3', 'Homage to Catalonia', 'George Orwell', 'Nonfiction', '9.99', '25', '0.24');
insert into book values ('924-7-90-847379-4', 'Gone Girl', 'Gillian Flynn', 'Fiction', '10.99', '25', '0.14');
insert into book values ('913-5-83-777536-8', 'The Time Machine', 'H. G. Wells', 'Fiction', '14.99', '20', '0.22');
insert into publisher values ('22222', 'Simon & Schuster', '166 King St E, Toronto, ON M5A 4S4', 'Human.Resources@SimonandSchuster.ca', '647-427-8882', '0');
insert into publisher values ('98878', 'Macmillan Publishers', 'Equitable Life Building, 120 Broadway, New York, NY 10271, United States', 'academic@macmillan.com', '646-600-7856', '0');
insert into publisher values ('01934', 'Hachette Livre', '1290 6th Ave, New York, NY 10104, USA', 'hello@hachettelivre.com', '1-212-364-1100', '0');
insert into publisher values ('35688', 'Penguin Random House', '1745 Broadway, New York, NY 10019, United States', 'hello@penguinrandomhouse.com', '1-800-793-2665', '0');
insert into publisher values ('11111', 'HarperCollins', '22 Adelaide St W, Toronto, ON M5H 4E3', 'hello@harpercollins.com', '1-800-242-7737', '0');
insert into warehouse values ('00001', '579 Church St, Toronto, ON M4Y 3E4', '343-535-3532');
insert into orders values ('FR536356863CV', 'Toronto', '400 North Avenue West, Raymond, Ab, Canada', '400 North Avenue West, Raymond, Ab, Canada', '2021-09-23');
insert into orders values ('FC436486453KM', 'Ottawa', 'Rue Nationale, Deux-montagnes, Qc, Canada', 'Wildwood Crescent North, Pitt Meadows, Bc, Canada', '2021-10-21');
insert into published values ('11111', '913-5-83-777536-8');
insert into published values ('35688', '924-7-90-847379-4');
insert into published values ('35688', '953-7-75-854649-3');
insert into published values ('35688', '975-4-83-846819-0');
insert into published values ('35688', '984-3-75-468549-9');
insert into published values ('01934', '932-9-47-145660-8');
insert into published values ('01934', '990-2-07-112360-4');
insert into published values ('98878', '951-8-07-142356-3');
insert into published values ('22222', '972-4-17-142110-4');
insert into published values ('22222', '985-2-53-447506-2');

insert into stock_by values ('972-4-17-142110-4', '00001', '10');

alter table add_to add b_number integer;
insert into add_to values ('913-5-83-777536-8', 'FC436486453KM', '1');
insert into add_to values ('924-7-90-847379-4', 'FC436486453KM', '1');
insert into add_to values ('932-9-47-145660-8', 'FC436486453KM', '1');

insert into customer values ('taylorswift35@gmail.com', 'Taylor Swift', '231-242-3345', '25 Gnatcatcher Avenue, North Las Vegas,nv, 89084  United States', '25 Gnatcatcher Avenue, North Las Vegas,nv, 89084  United States');
insert into customer values ('harrychen1996@yahoo.com', 'Harry Chen', '231-553-2315', 'Rue Nationale, Deux-montagnes, Qc, Canada', 'Rue Nationale, Deux-montagnes, Qc, Canada');
insert into customer values ('bensimmons233@yahoo.com', 'Ben Simmons', '342-342-5432', '400 North Avenue West, Raymond, Ab, Canada', '400 North Avenue West, Raymond, Ab, Canada');
insert into placed_by values ('FR536356863CV', 'bensimmons233@yahoo.com');
insert into placed_by values ('FC436486453KM', 'harrychen1996@yahoo.com');

