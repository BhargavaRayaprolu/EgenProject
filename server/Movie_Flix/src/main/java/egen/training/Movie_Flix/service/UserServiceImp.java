package egen.training.Movie_Flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.training.Movie_Flix.Exception.BadRequestException;
import egen.training.Movie_Flix.Exception.EntityNotFoundException;
import egen.training.Movie_Flix.entity.User;
import egen.training.Movie_Flix.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("User not foud");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("User not found");		
	}
		repository.delete(existing);
	}
}

