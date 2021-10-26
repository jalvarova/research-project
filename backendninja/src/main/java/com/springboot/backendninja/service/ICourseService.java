package com.springboot.backendninja.service;

import java.util.List;

import com.springboot.backendninja.entity.Course;
import com.springboot.backendninja.model.CourseModelS;

public interface ICourseService {

	public abstract List<CourseModelS> getListCourse();
	public abstract Course addCourse (Course Course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);


}
