package com.springboot.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.backendninja.component.ConvertEntityModel;
import com.springboot.backendninja.entity.Course;
import com.springboot.backendninja.model.CourseModelS;
import com.springboot.backendninja.repository.CourseJpaRepository;
import com.springboot.backendninja.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<CourseModelS> getListCourse() {
		
		List<CourseModelS> courseModels = listConverts();
		return courseModels;
	}

	@Override
	public Course addCourse(Course course) {
		
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		
		return courseJpaRepository.save(course);
	}

	private List<CourseModelS> listConverts(){
		
		List<CourseModelS> courseModels = new ArrayList<>();
		List<Course> listCourse = courseJpaRepository.findAll();
		for (Course course : listCourse) {
			
			courseModels.add(ConvertEntityModel.entityToModel(course));
		}
		return courseModels;
		
	}
}
