package efs.thesis.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
public class HomeController {

	@RequestMapping(value = {"/home", "/index"})
	public ModelAndView index(){
		return new ModelAndView("home");
	}
}
