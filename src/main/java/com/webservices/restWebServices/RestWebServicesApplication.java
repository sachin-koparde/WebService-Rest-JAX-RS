package com.webservices.restWebServices;

import com.webservices.restWebServices.Dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/*Write use the RESTful service to add, delete, update, and retrieve books from Bookstore.

		POST: Add books to the bookstore
		GET: Get books from the bookstore
		PUT: Updates books to the bookstore
		DELETE: Deletes books from the bookstore

		Can use consume and produce both xml/json and handle error if any operation failed .

		Sample book Json :
		{
		"isbn": "9390491622",
		"name": "Java: The Complete Reference - 11th Edition",
		"description": "The definitive guide to Java programming—thoroughly revised for long-term support release Java SE 11. Fully updated for the current version of Java, Java SE 11, This practical guide from Oracle press shows, step by step, how to design, write, troubleshoot, run, and maintain high-performance Java programs. Inside, bestselling author Herbert schildt covers the entire Java language, including its syntax, Keywords, and libraries. The book lays out cutting-edge programming techniques and best practices.",
		"authorName": "Herbert Schildt",
		"releaseDate": "10 December 2020",
		"vintage": true,
		"signed": true,
		"price": 940
		}

		Create the required database tables and design the webservice.*/


@SpringBootApplication
public class RestWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}


}
