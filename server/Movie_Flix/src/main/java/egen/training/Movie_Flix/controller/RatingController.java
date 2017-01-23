package egen.training.Movie_Flix.controller;


import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egen.training.Movie_Flix.entity.Rating;
import egen.training.Movie_Flix.service.RatingService;

@RestController
@RequestMapping(value = "rating")

public class RatingController {
	@Autowired
	private RatingService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Rating findById(@PathVariable("id") String id){
		return service.findByID(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Rating create(@RequestBody Rating rating, @RequestParam Map<String, String> params){
		return service.create(params, rating);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Rating update(String id, @RequestBody Rating rating){
		return service.update(id, rating);
}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}