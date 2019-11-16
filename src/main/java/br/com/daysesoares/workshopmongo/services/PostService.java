package br.com.daysesoares.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysesoares.workshopmongo.domain.Post;
import br.com.daysesoares.workshopmongo.repository.PostRepository;
import br.com.daysesoares.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
