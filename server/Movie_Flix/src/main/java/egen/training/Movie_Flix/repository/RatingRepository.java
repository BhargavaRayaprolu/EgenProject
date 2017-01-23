package egen.training.Movie_Flix.repository;


import java.util.List;

import egen.training.Movie_Flix.entity.Rating;

public interface RatingRepository {
	
	public List<Rating> findAll();
	
	public Rating findById(String id);
	
	public Rating create(Rating rating);
	
	public Rating update(Rating rating);

	public void delete(Rating rating);

}
