package egen.training.Movie_Flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.training.Movie_Flix.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
		}
	
	@Override
	public User create(User user){
		em.persist(user);
		return user;
	} 
	@Override
	public User update(User user){
		return em.merge(user);
	}	

	@Override
	public void delete(User user) {
		em.remove(user);
	}
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> Users = query.getResultList();
		if (Users != null && Users.size() == 1) {
			return Users.get(0);
		} else {
		return null;
		
	}
	}
}