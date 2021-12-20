# github_comp3005_project
Name: Jiajun Wu
Course: COMP3005A
Project Code

# Foobar

This is a demo for COMP3005A project

## Installation

Install Java (this programe uses JDBC)

Install PostgreSQL https://www.postgresql.org/

Download the PostgreSQL JDBC Driver https://jdbc.postgresql.org/
 
(If you are using Eclipse, make sure to add the JDBC driver to the build path)

## DDL and function

After installation, run both DDL.sql and Functions.sql file on PostgreSQL to create tables and insert basic data

## The program

The project main class is the Project.java

After download the code to your own mechine, make sure to update line 11 accordingly (listed below)

Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "asdfasdf")

Make sure change the address and name of the database and the password to your own.

After run, simply follow the steps in the command prompt.

(The inital admin password is: 911)

## Usage

Used for the project for course COMP3005
