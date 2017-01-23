package egen.training.Movie_Flix.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import egen.training.Movie_Flix.entity.Rating;

@Repository
public class RatingRepositoryImp implements RatingRepository {
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Rating findById(String id) {
		return em.find(Rating.class, id);
	}

	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}

	@Override
	public Rating update(Rating rating) {
		return em.merge(rating);
	}

	@Override
	public void delete(Rating rating) {
		em.remove(rating);
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}