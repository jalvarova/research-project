package com.springboot.backendninja.controller;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.backendninja.model.CourseModel;
import com.springboot.backendninja.util.ConstanstMVC;

@Controller
@RequestMapping(ConstanstMVC.MAPPING_EXAMPLE_FORM)
public class FormController {

	private static final Log LOOGER = LogFactory.getLog(FormController.class);
	
	@GetMapping(ConstanstMVC.VEXAMPLE_SHOW_FORM)
	public String showForm(Model model) {

		model.addAttribute("course", new CourseModel());
		//int divi = 6/0;
		return ConstanstMVC.VCONTROLLER_CREATE_COURSE;
	}

	@GetMapping("/")
	public RedirectView redirect(HttpServletRequest request){
		LOOGER.info("Redirect Mapping " + request.getPathInfo());

		return new RedirectView(ConstanstMVC.MAPPING_EXAMPLE_FORM+ConstanstMVC.VEXAMPLE_SHOW_FORM);
	}
	
	@PostMapping(ConstanstMVC.VEXAMPLE_ADD_COURSE)
	public ModelAndView addCourse(@Valid @ModelAttribute("course") CourseModel courseModel,BindingResult bindingResult) {
		LOOGER.info("METHOD: addCourse --  Parameters: " + courseModel + " of the Model " + courseModel.getClass().getSimpleName() );
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(ConstanstMVC.VCONTROLLER_CREATE_COURSE);
		}else{
			modelAndView.addObject("course",courseModel);
			modelAndView.setViewName(ConstanstMVC.VCONTROLLER_CREATE_RESULT);
		}
	
		return modelAndView;
	}
}
