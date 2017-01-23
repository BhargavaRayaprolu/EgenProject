package egen.training.Movie_Flix.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.training.Movie_Flix.Exception.BadRequestException;
import egen.training.Movie_Flix.Exception.EntityNotFoundException;
import egen.training.Movie_Flix.entity.Rating;
import egen.training.Movie_Flix.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	private RatingRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Rating> findAll() {
		return repository.findAll();
	}

	@Override
	public Rating findByID(String id) {
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating not found");
		}
		return existing;
	}

	@Override
	public Rating create(Map<String, String> params, Rating rating) {		
		Rating existing = repository.findById(rating.getId());
		if (existing != null) {
			throw new BadRequestException("Employee with this email already exists");
		}
		return repository.create(rating);
	}

	@Override
	@Transactional
	public Rating update(String id, Rating rating) {
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating is not found for this id");
		}
		return repository.update(rating);
	}

	@Override
	public void delete(String id) {		
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating is not found for this id");
		}
		repository.delete(existing);

	}

}
