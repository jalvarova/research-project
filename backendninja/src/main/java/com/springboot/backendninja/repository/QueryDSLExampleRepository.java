package com.springboot.backendninja.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.springboot.backendninja.entity.Course;
import com.springboot.backendninja.entity.QCourse;

@Repository
public class QueryDSLExampleRepository {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public void queryLan() {

		JPAQuery<Course> query = new JPAQuery<>();

		Course course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(1)).fetchOne();

		if (course!=null) {
			System.err.println("No hay NadaS");
			
		}
		System.err.println(course.toString());

	}
}
