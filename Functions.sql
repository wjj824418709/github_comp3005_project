//function to get the current date for the orders table
CREATE or replace FUNCTION curdate() RETURNS date AS $$
    BEGIN
        RETURN current_date;
    END; $$
LANGUAGE PLPGSQL;

//triggers and function to update the p_cut variable when an insert is made on add_to table
create or replace function add_publish_cut()
	returns trigger as
$$
begin
	update publisher set banking_account = 
	(select p_cut from book where isbn = new.isbn) * 
	(select b_number from add_to where isbn = new.isbn, order_number = new.order_number) *
	(select price from book where isbn = new.isbn)
	where id = (select from published where isbn = new.isbn);
	return new;
end;
$$ LANGUAGE plpgsql; 

CREATE TRIGGER p_cut_update 
AFTER insert on add_to FOR EACH ROW 
EXECUTE PROCEDURE add_publish_cut();
	
//view to see the sales per genres
create view fiction_salesas as
select genre, name, isbn, add_to.order_number, book.price, add_to.b_number, book.price*add_to.b_number as total_price
FROM add_to natural full outer join book
where genre = 'Fiction' and order_number is not NULL;

create view nonfiction_salesas as
select genre, name, isbn, add_to.order_number, book.price, add_to.b_number, book.price*add_to.b_number as total_price
FROM add_to natural full outer join book
where genre = 'Nonfiction' and order_number is not NULL; 

//view to see the sales per author
create view author_view as
select author, book.name, add_to.order_number, book.price, add_to.b_number, book.price*add_to.b_number as t_price
FROM add_to natural full outer join book
where order_number is not null; 
