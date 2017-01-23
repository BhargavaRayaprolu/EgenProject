package egen.training.Movie_Flix.service;

import java.util.List;

import egen.training.Movie_Flix.entity.Movie;


public interface MovieService {	

	public List<Movie> findAll();

	public Movie findById(String id);

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void delete(String id);

}
