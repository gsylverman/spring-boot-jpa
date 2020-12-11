package com.gavril.springmvcjparest02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gavril.springmvcjparest02.dao.MyRepoI;
import com.gavril.springmvcjparest02.model.Person;

@RestController
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
	
	@RequestMapping(value = "getPeople", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Person> getPeopleList(Model m) {
//		m.addAttribute("people", myrepo.findAll());
		return myrepo.findAll();
	}
	
	@GetMapping("getPersonByName")
	public List<Person> getPersonByName(@RequestParam("name") String name1, Model m) {
		
		return myrepo.getPersonByName(name1);
	}
	
	@GetMapping("getPersonByName/{name}")
	public List<Person> getPersonByNamePathVariable(@PathVariable("name") String name1, Model m) {
		
		return myrepo.getPersonByName(name1);
	}
	
	@GetMapping("update-tech")
	public String update(@RequestParam("tech") String tech) {
		System.out.println(myrepo.updateTechField(tech));
		
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
