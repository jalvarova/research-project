package com.springboot.backendninja.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.backendninja.model.*;
import com.springboot.backendninja.util.ConstanstMVC;

@Controller
@RequestMapping(ConstanstMVC.VRQMAPPING_EXAMPLE)
public class ExampleController {
	private static final Log LOG = LogFactory.getLog(ExampleController.class);


	// @RequestMapping(value="/exampleString",method=RequestMethod.GET)
	@GetMapping(ConstanstMVC.VEXAMPLE_STRING)
	public String exampleString(Model model) {
		PersonModel personModel = new PersonModel("Alvaro", "25");

		model.addAttribute("person", personModel);
		model.addAttribute("courses", getListCourse());
		return ConstanstMVC.VCONTROLLER_EXAMPLE;
	}

	// @RequestMapping(value="/exampleMAV",method=RequestMethod.GET)
	@GetMapping(ConstanstMVC.VEXAMPLE_MAV)
	public ModelAndView exampleMAV() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "Diego");
		modelAndView.setViewName(ConstanstMVC.VCONTROLLER_EXAMPLE);
		return modelAndView;
	}

	@GetMapping(ConstanstMVC.VEXAMPLE_FILTER)
	public ModelAndView exampleFilter(@RequestParam(name = "cod") String codigo) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", findCourseById(codigo));
		modelAndView.setViewName(ConstanstMVC.VCONTROLLER_FILTER_EXAMPLE);
		return modelAndView;
	}

	@GetMapping(ConstanstMVC.VEXAMPLE_FILTER_PATH)
	public ModelAndView exampleFilterPath(@PathVariable(name = "cod") String codigo) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", findCourseById(codigo));
		modelAndView.setViewName(ConstanstMVC.VCONTROLLER_FILTER_EXAMPLE);
		return modelAndView;
	}

	@GetMapping(ConstanstMVC.VEXAMPLE_CREATE)
	public ModelAndView exampleCreate(Model model) {

		ModelAndView modelAndView = new ModelAndView();
		CourseModel courseModel = new CourseModel();

		model.addAttribute("course", createCourse(courseModel.getCodCourse(), courseModel.getDescripCourse()));
		model.addAttribute("courses",getListCourse());
		modelAndView.setViewName(ConstanstMVC.VCONTROLLER_CREATE_EXAMPLE);
		return modelAndView;
	}

	private CourseModel createCourse(String code, String description) {

		CourseModel courseModel = new CourseModel(code, description);

		return courseModel;
	}

	private List<CourseModel> findCourseById(String codigo) {

		List<CourseModel> courseModels = getListCourse();
		List<CourseModel> filerCourseModels = new ArrayList<>();
		for (CourseModel courseModel : courseModels) {
			if (codigo.equals(courseModel.getCodCourse())) {

				filerCourseModels.add(courseModel);
				LOG.info("MODEL: " + courseModel.getClass().getSimpleName() + " : " + courseModel);
				break;
			}

		}

		return filerCourseModels;
	}

	public List<CourseModel> getListCourse() {
		List<CourseModel> courseModels = new ArrayList<>();

		courseModels.add(new CourseModel("0001", "math"));
		courseModels.add(new CourseModel("0002", "communication"));
		courseModels.add(new CourseModel("0003", "science"));
		courseModels.add(new CourseModel("0004", "philosophy"));
		LOG.info("LIST OF THE COURSES");
		return courseModels;
	}
}
