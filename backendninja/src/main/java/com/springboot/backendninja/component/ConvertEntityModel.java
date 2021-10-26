package com.springboot.backendninja.component;


import com.springboot.backendninja.entity.Course;
import com.springboot.backendninja.model.CourseModelS;


public final class ConvertEntityModel {

	public static CourseModelS entityToModel(Course course){
		
		
		CourseModelS courseModel = new CourseModelS();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}

	public static Course modelToEntity(CourseModelS courseModel){
		
		Course course = new Course();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}
	
}
