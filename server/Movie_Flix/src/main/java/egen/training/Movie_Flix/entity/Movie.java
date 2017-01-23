package egen.training.Movie_Flix.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries ({
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle ORDER BY m.year DESC") ,
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findAllSortByRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating ASC"),
	@NamedQuery(name = "Movie.findAllSortByVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes ASC"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.title ASC"),
})

public class Movie {

	@Id
	private String id;	
	
	public Movie() {
		this.id = UUID.randomUUID().toString();
	}
	@Column(unique = true)
	private String title;
	
	private int year;
	
	private String country;
	
	private double imdbRating;
	
	private int imdbVotes;
	
	private String imdbId;
	
	private String type;
	
	private int metaScore;	
	

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Cast> cast; 

	public Set<Cast> getCast() {
		return cast;
	}
	public void setCast(Set<Cast> cast) {
		this.cast = cast;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	
}
