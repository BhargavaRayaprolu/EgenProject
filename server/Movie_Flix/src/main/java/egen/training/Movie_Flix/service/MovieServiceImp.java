package egen.training.Movie_Flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.training.Movie_Flix.Exception.EntityNotFoundException;
import egen.training.Movie_Flix.entity.Movie;
import egen.training.Movie_Flix.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findById(String id) {
		Movie existing = repository.findById(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie not foud");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null) {
			throw new EntityNotFoundException("Movie with this title does not exist");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findById(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findById(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie not found");		
	}
		repository.delete(existing);

	}

}
