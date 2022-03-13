package com.example.demogopalcSpringBoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.sql.DataSource;

import java.sql.ResultSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.util.Properties;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;


import java.math.* ; // for BigDecimal and BigInteger support

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import microsoft.sql.DateTimeOffset;


@SpringBootApplication
public class DemogopalcSpringBootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemogopalcSpringBootApplication.class, args);
		try {
			connectDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	static void connectDB() throws ClassNotFoundException, SQLException {
		
		String USER="gopalc";
		String PASSWD="Secret1!";
		
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	    
	    String connectionUrl = "jdbc:sqlserver://localhost:49713;database=R_Db;integratedSecurity=false;";
	    Connection con = DriverManager.getConnection(connectionUrl,USER,PASSWD);  
		
        Statement stmt = con.createStatement();
	  
		String sql = "Select * from Student";
	
		ResultSet rs = stmt.executeQuery(sql);
		//6. Process the result set
		while (rs.next()) {
			//proces individual rows matching criteria
			String studentName = rs.getString("student_name");
			int studentMarks = rs.getInt("student_marks");
		}
	}
	

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}		

		};		
		
	}
}
