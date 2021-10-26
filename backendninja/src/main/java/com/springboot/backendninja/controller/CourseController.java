package com.springboot.backendninja.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.backendninja.component.ConvertEntityModel;
import com.springboot.backendninja.model.CourseModelS;
import com.springboot.backendninja.service.ICourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    private ICourseService courseService;

    public static final String FORM_COURSE = "course";

    @GetMapping("/list")
    public ModelAndView listAllCourses() {
        ModelAndView mav = new ModelAndView();
        List<CourseModelS> listCourseModels = courseService.getListCourse();
        mav.addObject("course", new CourseModelS());
        mav.addObject("courses", listCourseModels);

        //LOG.info(listCourseModels.listIterator().next());
        mav.setViewName(FORM_COURSE);
        return mav;
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") CourseModelS courseModel) {
        LOG.info("Call  addCourse() -- Param " + courseModel.toString());
        courseService.addCourse(ConvertEntityModel.modelToEntity(courseModel));

        return "redirect:/courses/list";
    }

    @GetMapping("/list/json")
    public List<CourseModelS> listCourses() {
        return courseService.getListCourse();
    }
}
