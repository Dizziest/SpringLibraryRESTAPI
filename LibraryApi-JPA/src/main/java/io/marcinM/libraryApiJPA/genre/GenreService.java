package io.marcinM.libraryApiJPA.genre;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepo;
	
	public List<Genre> getAllGenres(){
		List<Genre> genres = new ArrayList<>();
		genreRepo.findAll().forEach(genres::add);
		return genres;
	}
	
	public Genre getGenre(int id) {
		return genreRepo.getOne(id);
	}
	
	public void addGenre(Genre genre) {
		genreRepo.save(genre);
	}
	
	public void updateGenre(Genre genre, int id) {
		genreRepo.save(genre);
	}
	
	public void deleteGenre(int id) {
		genreRepo.deleteById(id);
	}
	
	

}
