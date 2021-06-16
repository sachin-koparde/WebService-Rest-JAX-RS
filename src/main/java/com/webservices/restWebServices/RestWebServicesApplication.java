package com.webservices.restWebServices;

import com.webservices.restWebServices.Dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class RestWebServicesApplication {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BookRepository bookDao;

//	@PostConstruct
//	public void init() {
//		bookDao.saveAll(Stream.of(
//				new Book(91123876743L, "Learn Java", "Reference book to learn Java", "ABC", LocalDate.of(2008, Month.DECEMBER, 20), false, true, 200.0),
//				new Book(27709876709L, "Playing It My Way", "Auto-biography by Sachin Tendulkar", "Sachin Tendulkar", LocalDate.of(2016, Month.APRIL, 24 ), false, true, 460.0),
//				new Book(56312387873L, "Python in hand", "Learning Python", "XYZ", LocalDate.of(2012, Month.DECEMBER, 23), false, false, 180.0)
//		).collect(Collectors.toList()));
//	}

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}


}
