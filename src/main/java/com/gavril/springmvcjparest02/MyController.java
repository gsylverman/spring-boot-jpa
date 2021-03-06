package com.gavril.springmvcjparest02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gavril.springmvcjparest02.dao.MyRepoI;
import com.gavril.springmvcjparest02.model.Person;

@Controller
public class MyController {
	
	@Autowired
	private MyRepoI myrepo;
	
	@RequestMapping("/")
	public String getPage() {	
		return "index";
	}
	
	@RequestMapping(value = "add-person", method = RequestMethod.GET)
	public String add(Person person, Model m) {
		List<Person> list = myrepo.findAll();
		if(!list.contains(person)) {
			myrepo.save(person);
		}
				
		m.addAttribute("people", list);
		return "show";
	}
	
	@GetMapping("getPeople")
	public String getPeopleList(Model m) {
		m.addAttribute("people", myrepo.findAll());
		return "show";
	}
	
	@GetMapping("getPersonByName")
	public String getPersonByName(@RequestParam("name") String name1, Model m) {
		
		m.addAttribute("people", myrepo.getPersonByName(name1));
		
		return "show";
	}
	@RequestMapping(value = "getPersonById", method = RequestMethod.GET)
	public ModelAndView getPerson(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("show");
//		mv.setViewName("show");
		Person person = myrepo.findById(id).orElse(new Person());
		mv.addObject("people", person);
		return mv;
	}
}
