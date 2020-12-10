package com.gavril.springmvcjparest02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gavril.springmvcjparest02.dao.MyRepoI;
import com.gavril.springmvcjparest02.model.People;

@Controller
public class MyController {
	
	@Autowired
	private MyRepoI myrepo;
	
	@RequestMapping("/")
	public String getPage() {	
		return "index";
	}
	
	@RequestMapping(value = "add-people", method = RequestMethod.GET)
	public String add(People people, Model m) {
		List<People> list = myrepo.findAll();
		if(!list.contains(people)) {
			myrepo.save(people);
		}
				
		m.addAttribute("peoples", list);
		return "show";
	}
	
	@RequestMapping(value = "getPeople", method = RequestMethod.GET)
	public ModelAndView getPeople(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("show");
//		mv.setViewName("show");
		People people = myrepo.findById(id).orElse(new People());
		mv.addObject("peoples", people);
		return mv;
	}
}
