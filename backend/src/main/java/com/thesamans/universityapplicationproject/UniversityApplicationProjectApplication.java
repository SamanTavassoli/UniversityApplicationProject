package com.thesamans.universityapplicationproject;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { UserDao.class, CourseDao.class }) // TODO not sure what this does
public class UniversityApplicationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplicationProjectApplication.class, args);

	}

}
