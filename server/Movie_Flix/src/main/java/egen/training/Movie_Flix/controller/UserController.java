package egen.training.Movie_Flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import egen.training.Movie_Flix.entity.User;
import egen.training.Movie_Flix.service.UserService;


@RestController
@RequestMapping(value = "user")

public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String id) {
		return service.findOne(id);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		 return service.create(user);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
