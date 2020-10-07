package com.thesamans.universityapplicationproject;

import com.thesamans.universityapplicationproject.dao.ApplicationDao;
import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { UserDao.class, CourseDao.class, ApplicationDao.class })
public class UniversityApplicationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplicationProjectApplication.class, args);

	}

}
