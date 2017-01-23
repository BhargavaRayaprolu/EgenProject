package egen.training.Movie_Flix.repository;

import java.util.List;

import egen.training.Movie_Flix.entity.Movie;

public interface MovieRepository {
	
	public Movie findByTitle(String title);
	
	public List<Movie> findAll();

	public Movie findById(String id);
	
	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
}
