package egen.training.Movie_Flix.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import egen.training.Movie_Flix.entity.Movie;
import egen.training.Movie_Flix.service.MovieService;

@RestController
@RequestMapping(value = "movie")

public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findById(@PathVariable("id") String id) {
		return service.findById(id);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		 return service.create(movie);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) {
		return service.update(id, movie);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
