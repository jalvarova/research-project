package com.springboot.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springboot.backendninja.entity.Course;
import com.springboot.backendninja.repository.CourseJpaRepository;

@Component
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

	@Autowired
	@Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

	public Course addCourse(Course course) {

		course = new Course();

		course.setName("Math");
		course.setDescription("Course thn Math");
		course.setPrice("180.00");
		course.setHours("3:00");

		Course newcourse = new Course();
		if (course != null) {
			newcourse = courseJpaRepository.save(course);
			LOG.info(newcourse);
		}
		return newcourse;
	}

}
