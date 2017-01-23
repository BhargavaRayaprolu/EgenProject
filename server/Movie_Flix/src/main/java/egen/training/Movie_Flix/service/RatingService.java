package egen.training.Movie_Flix.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import egen.training.Movie_Flix.entity.Rating;

@Component
public interface RatingService {
	
	public List<Rating> findAll();
	
	public Rating findByID(String id);
	
	public Rating create(Map<String, String> params, Rating rating);
	
	public Rating update(String id, Rating rating);
	
	public void delete(String id);

}
