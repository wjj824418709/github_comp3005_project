package net.codejava;

import java.sql.*;
import java.util.*;  
import java.util.ArrayList; 

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "wjj1997911");
	            Statement statement = connection.createStatement();
	            ) 
	        {
	            Scanner sc= new Scanner(System.in); 
	            System.out.print("Welcom to GG bookstore!" + "\n");
	            int uInput = 0;
	            String sql_check;
	            System.out.print("Please enter your email address: ");  
	        	String s_email = sc.nextLine();   
		        System.out.print("You have entered: "+ s_email + "\n");
	            sql_check = "select * from customer where email = '" + s_email + "'";
	            ResultSet rs = statement.executeQuery(sql_check);
	            
	            if(rs.next()) {
	            	System.out.print("You are registered with GG bookstore!" + "\n"); 
	            	System.out.print("Please select the following options: " + "\n"); 
	            	System.out.print("1. Search a book" + "\n"); 
	            	System.out.print("2. Browse all book" + "\n"); 
	            	System.out.print("3. Track an order" + "\n"); 
	            	System.out.print("4. Place an order" + "\n");
	            	System.out.print("5. Owner option" + "\n");
	            	uInput = sc.nextInt(); 
	            }else {
	            	System.out.print("You are not registered with GG bookstore! Goodbye" + "\n"); 
	            	System.out.print("Sorry we couldn't find you in our database, please register." + "\n");
	            	System.out.print("Please enter your email address: ");
            		String em_ad = sc.nextLine();
            		String temp;
            		sql_check = "insert into customer(email) values ('" + em_ad + "')";
        			statement.executeUpdate(sql_check);
        			System.out.print("Please enter your name: ");
        			temp = sc.nextLine();
        			sql_check = "UPDATE customer SET name = '" + temp + "' WHERE email = '" + em_ad + "'";
        			statement.executeUpdate(sql_check);
        			
        			System.out.print("Please enter your phone number: ");
        			temp = sc.nextLine();
        			sql_check = "UPDATE customer SET phone = '" + temp + "' WHERE email = '" + em_ad + "'";
        			statement.executeUpdate(sql_check);
        			
        			System.out.print("Please enter your billing_address: ");
        			temp = sc.nextLine();
        			sql_check = "UPDATE customer SET billing_address = '" + temp + "' WHERE email = '" + em_ad + "'";
        			statement.executeUpdate(sql_check);
        			
        			System.out.print("Please enter your shipping_address: ");
        			temp = sc.nextLine();
        			sql_check = "UPDATE customer SET shipping_address = '" + temp + "' WHERE email = '" + em_ad + "'";
        			statement.executeUpdate(sql_check);
        			System.out.print("You are registered with GG bookstore!" + "\n"); 
	            	System.out.print("Please select the following options: " + "\n"); 
	            	System.out.print("1. Search a book" + "\n"); 
	            	System.out.print("2. Browse all book" + "\n"); 
	            	System.out.print("3. Track an order" + "\n"); 
	            	System.out.print("4. Place an order" + "\n");
	            	System.out.print("5. Owner option" + "\n");
        			uInput = sc.nextInt(); 
	            }
			            

           	
	            
	            
	            if(uInput == 1) {
	            	System.out.print("Please select the following options: " + "\n"); 
	            	System.out.print("1. Search a book by name" + "\n"); 
	            	System.out.print("2. Search a book by ISBN" + "\n"); 
	            	System.out.print("3. Search a book by author" + "\n"); 
	            	System.out.print("4. Search a book by genre" + "\n"); 
	            	int sInput = sc.nextInt();
	            	if(sInput == 1){
	            		System.out.print("Please enter a book name: ");
	            		sc.nextLine();
	            		String uInputS = sc.nextLine();
	            		sql_check = "select * from book where name = '" + uInputS + "'";
	            		rs = statement.executeQuery(sql_check);
	            		if(rs.next()) {
	            			System.out.print("We have the book you are looking for!" + "\n"); 
	            			System.out.print("Book name: " + rs.getString("name") + "\n"); 
	            			System.out.print("Book ISBN: " + rs.getString("isbn") + "\n"); 
	            			System.out.print("Book author: " + rs.getString("author") + "\n"); 
	            			System.out.print("Book genre: " + rs.getString("genre") + "\n"); 
	            			System.out.print("Book price: " + rs.getString("price") + "\n"); 
	            			System.out.print("Book pages: " + rs.getString("pages") + "\n");
	            			System.out.print("Book left: " + rs.getString("numbers") + "\n");
	            		}
	            	}
	            	
	            	if(sInput == 2){
	            		System.out.print("Please enter a book ISBN: ");
	            		sc.nextLine();
	            		String uInputS = sc.nextLine();
	            		sql_check = "select * from book where ISBN = '" + uInputS + "'";
	            		rs = statement.executeQuery(sql_check);
	            		if(rs.next()) {
	            			System.out.print("We have the book you are looking for!" + "\n"); 
	            			System.out.print("Book name: " + rs.getString("name") + "\n"); 
	            			System.out.print("Book ISBN: " + rs.getString("isbn") + "\n"); 
	            			System.out.print("Book author: " + rs.getString("author") + "\n"); 
	            			System.out.print("Book genre: " + rs.getString("genre") + "\n"); 
	            			System.out.print("Book price: " + rs.getString("price") + "\n"); 
	            			System.out.print("Book pages: " + rs.getString("pages") + "\n");
	            			System.out.print("Book left: " + rs.getString("numbers") + "\n");
	            		}
	            	}
	            	
	            	if(sInput == 3){
	            		System.out.print("Please enter a book author: ");
	            		sc.nextLine();
	            		String uInputS = sc.nextLine();
	            		sql_check = "select * from book where author = '" + uInputS + "'";
	            		rs = statement.executeQuery(sql_check);
	            		while(rs.next()) {
	            			System.out.print("The following book fits the category!" + "\n"); 
	            			System.out.print("Book name: " + rs.getString("name") + "\n"); 
	            			System.out.print("Book ISBN: " + rs.getString("isbn") + "\n"); 
	            			System.out.print("Book author: " + rs.getString("author") + "\n"); 
	            			System.out.print("Book genre: " + rs.getString("genre") + "\n"); 
	            			System.out.print("Book price: " + rs.getString("price") + "\n"); 
	            			System.out.print("Book pages: " + rs.getString("pages") + "\n");
	            			System.out.print("Book left: " + rs.getString("numbers") + "\n");
	            		}
	            	}
	            	
	            	if(sInput == 4){
	            		System.out.print("Please enter a book genre: ");
	            		sc.nextLine();
	            		String uInputS = sc.nextLine();
	            		sql_check = "select * from book where genre = '" + uInputS + "'";
	            		rs = statement.executeQuery(sql_check);
	            		while(rs.next()) {
	            			System.out.print("The following book fits the category!" + "\n"); 
	            			System.out.print("Book name: " + rs.getString("name") + "\n"); 
	            			System.out.print("Book ISBN: " + rs.getString("isbn") + "\n"); 
	            			System.out.print("Book author: " + rs.getString("author") + "\n"); 
	            			System.out.print("Book genre: " + rs.getString("genre") + "\n"); 
	            			System.out.print("Book price: " + rs.getString("price") + "\n"); 
	            			System.out.print("Book pages: " + rs.getString("pages") + "\n");
	            			System.out.print("Book left: " + rs.getString("numbers") + "\n");
	            			System.out.print("\n");
	            		}
	            	}
	            }
	            
	            if(uInput == 2) {
	            	sql_check = "select * from book";
	            	rs = statement.executeQuery(sql_check);
	            	int numB = 1;
            		while(rs.next()) { 
            			System.out.print("Book number " + numB + "\n"); 
            			System.out.print("Book name: " + rs.getString("name") + "\n"); 
            			System.out.print("Book ISBN: " + rs.getString("isbn") + "\n"); 
            			System.out.print("Book author: " + rs.getString("author") + "\n"); 
            			System.out.print("Book genre: " + rs.getString("genre") + "\n"); 
            			System.out.print("Book price: " + rs.getString("price") + "\n"); 
            			System.out.print("Book pages: " + rs.getString("pages") + "\n");
            			System.out.print("Book left: " + rs.getString("numbers") + "\n");
            			numB++;
            			System.out.print("\n");
            		}
	            }
	            
	            if(uInput == 3) {
	            	System.out.print("Please enter an order number: ");
            		sc.nextLine();
            		String uInputS = sc.nextLine();
            		sql_check = "select * from orders where order_number = '" + uInputS + "'";
	            	rs = statement.executeQuery(sql_check);
            		while(rs.next()) { 
            			System.out.print("Your order is currently at " + rs.getString("order_location") + "\n"); 
            			System.out.print("\n");
            		}
	            }
	            
	            if(uInput == 4) {
	            	System.out.print("Please enter the book's ISBN: ");
            		sc.nextLine();
            		String u_isbn = sc.nextLine();
            		sql_check = "select * from book where ISBN = '" + u_isbn + "'";
            		rs = statement.executeQuery(sql_check);
            		if(rs.next()) {
            			System.out.print("Please enter the amount you want to order: ");
            			int o_amount = sc.nextInt();
            			Random rnd = new Random();
            			int n = 100000 + rnd.nextInt(900000);
            			//insert into orders(order_number) values ('2342425')
            			sql_check = "insert into orders(order_number) values ('" + n + "')";
            			statement.executeUpdate(sql_check);
            			sql_check = "UPDATE orders SET order_location = 'Ottawa' WHERE order_number = '" + n + "'";
            			statement.executeUpdate(sql_check);
            			System.out.print("Please enter the billing_address: ");
            			sc.nextLine();
            			String uInputS = sc.nextLine();
            			sql_check = "UPDATE orders SET billing_address = '" + uInputS + "' WHERE order_number = '" + n + "'";
            			statement.executeUpdate(sql_check);
            			System.out.print("Please enter the shipping_address: ");
            			uInputS = sc.nextLine();
            			sql_check = "UPDATE orders SET shipping_address = '" + uInputS + "' WHERE order_number = '" + n + "'";
            			statement.executeUpdate(sql_check);
            			sql_check = "UPDATE orders SET order_date = curdate() WHERE order_number = '" + n + "'";
            			statement.executeUpdate(sql_check);
            			sql_check = "insert into add_to values ('" + u_isbn + "', '" + n + "', '" + o_amount + "')";
            			statement.executeUpdate(sql_check);
            			sql_check = "select numbers from book where isbn = '" + u_isbn + "'";
            			rs = statement.executeQuery(sql_check);
            			if(rs.next()) {
            				int num =rs.getInt("numbers");
                			sql_check = "UPDATE book SET numbers = '" + (num - o_amount) + "' WHERE isbn = '" + u_isbn + "'";
                			statement.executeUpdate(sql_check);
            			}
            			System.out.print("Order placed successful!" + "\n"); 
            			
            			
            			
            		}else {
            			System.out.print("Sorry, no such book found under this ISBN.");
            			System.exit(0);
            		}
            		
	            	
            		
	            }
	            
	            if(uInput == 5) {
	            	System.out.print("Please enter the admin password: ");
            		sc.nextLine();
            		String passw = sc.nextLine();
            		if(passw.compareTo("911") == 0) {
            			System.out.print("Welcome to admin page!" + "\n"); 
            			System.out.print("1. add a book" + "\n"); 
    	            	System.out.print("2. delete a book" + "\n"); 
    	            	System.out.print("3. Update publisher cut" + "\n"); 
    	            	System.out.print("4. See sales per author" + "\n");
    	            	System.out.print("5. See sales per genres" + "\n");
    	            	System.out.print("6. See sales per author" + "\n");
    	            	int oop = sc.nextInt();
    	            	if(oop == 1) {
    	            		System.out.print("Please enter the ISBN of the book you want to order: ");
    	            		sc.nextLine();
                			String newISBN = sc.nextLine();
                			sql_check = "insert into book(isbn) values ('" + newISBN + "')";
                			statement.executeUpdate(sql_check);
    	            		System.out.print("Please enter the name of the book you want to order: ");
    	            		String nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET name = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the author of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET author = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the genre of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET genre = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the price of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET price = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the amounts of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET numbers = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the publisher cut of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET p_cut = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the pages of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "UPDATE book SET pages = '" + nbtemp + "' WHERE isbn = '" + newISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("Please enter the publisher id of the book you want to order: ");
                			nbtemp = sc.nextLine();
                			sql_check = "insert into published values ('" + nbtemp + "', '" + newISBN + "');";
                			statement.executeUpdate(sql_check);
                			
                			
                			System.out.print("The new book has been added!" + "\n");
    	            	}
    	            	
    	            	if(oop == 2) {
    	            		System.out.print("Please enter the ISBN of the book you want to delete: ");
    	            		sc.nextLine();
                			String delISBN = sc.nextLine();
                			sql_check = "DELETE FROM book WHERE isbn = '" + delISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("The new book has been deleted!" + "\n");
    	            	}
    	            	
    	            	if(oop == 3) {
    	            		System.out.print("Please enter the ISBN of the book you want to update: ");
    	            		sc.nextLine();
                			String nISBN = sc.nextLine();
    	            		System.out.print("Please enter the new publisher percentage: ");
    	            		String newP = sc.nextLine();
                			sql_check = "UPDATE book SET p_cut = '" + newP + "' WHERE isbn = '" + nISBN + "'";
                			statement.executeUpdate(sql_check);
                			System.out.print("The new publisher percentage has been updated!" + "\n");
    	            	}
    	            	
    	            	if(oop == 4){
    	            		sql_check = "SELECT * FROM author_view";
    	            		rs = statement.executeQuery(sql_check);
    	            		while(rs.next()) {
    	            			System.out.print("Book name: " + rs.getString("name") + ", "); 
    	            			System.out.print("Book author: " + rs.getString("author") + ", "); 
    	            			System.out.print("Book price: " + rs.getString("price") + ", "); 
    	            			System.out.print("Book number sold: " + rs.getString("b_number") + ", ");
    	            			System.out.print("Book sales: " + rs.getString("t_price") + "\n");
    	            	}
    	            	
    	            	if(oop == 5) {
    	            		System.out.print("1. Fiction Sales" + "\n"); 
        	            	System.out.print("2. Nonfiction Sales" + "\n"); 
    	            		int ficOrNonf = sc.nextInt();
    	            		if(ficOrNonf == 1) {
    	            			sql_check = "SELECT * FROM fiction_sales";
        	            		rs = statement.executeQuery(sql_check);
        	            		while(rs.next()) {
        	            			System.out.print("Book name: " + rs.getString("name") + ", "); 
        	            			System.out.print("Book genre: " + rs.getString("genre") + ", "); 
        	            			System.out.print("Book price: " + rs.getString("price") + ", "); 
        	            			System.out.print("Book number sold: " + rs.getString("b_number") + ", ");
        	            			System.out.print("Book sales: " + rs.getString("total_price") + "\n");
        	            		}
    	            		}
    	            		
    	            		if(ficOrNonf == 2) {
    	            			sql_check = "SELECT * FROM nonfiction_sales";
        	            		rs = statement.executeQuery(sql_check);
        	            		while(rs.next()) {
        	            			System.out.print("Book name: " + rs.getString("name") + ", ");
        	            			System.out.print("Book genre: " + rs.getString("genre") + ", "); 
        	            			System.out.print("Book price: " + rs.getString("price") + ", "); 
        	            			System.out.print("Book number sold: " + rs.getString("b_number") + ", ");
        	            			System.out.print("Book sales: " + rs.getString("total_price") + "\n");
        	            		}
    	            		}
    	            	}
    	            	
    	            	
    	            		
            		}else {
    	            	System.out.print("Wrong passwrod, you are not the owner, goodbye!" + "\n");

            		}
	            }
	            
	            sc.close();
	            
	            }
	 
	        } catch (Exception sqle) {
	            System.out.println("Exception: " + sqle);
	        }

	}

}
