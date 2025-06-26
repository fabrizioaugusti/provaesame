package com.provaesame.provaesame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.provaesame.provaesame.entity.Post;
import com.provaesame.provaesame.model.PostDTO;
import com.provaesame.provaesame.repository.PostRepository;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository repository;

     @Autowired
    private WebClientPostService webClientService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public void retrievePostsFromWeb() {
        List<PostDTO> posts = webClientService.getPosts();
        posts.forEach(post -> {
            post.setId(0);
            createPost(post);
        }); 
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> lista = (List<Post>) repository.findAll();
        List<PostDTO> dtos = new ArrayList<>();
        lista.forEach(entity -> {
            dtos.add(modelMapper().map(entity, PostDTO.class));
        });
        return dtos;
    }

    @Override
    public PostDTO createPost(PostDTO post) {
        Post entity = modelMapper().map(post, Post.class);
        repository.save(entity);
        return modelMapper().map(entity, PostDTO.class);
    }

    @Override
    public PostDTO getPostById(int id) {
        Optional<Post> entity = repository.findById(id);

        return entity.isPresent() ? modelMapper().map(entity, PostDTO.class) : new PostDTO();

    }

    @Override
    public PostDTO updatePost(PostDTO post) {
        Post entity = modelMapper().map(post, Post.class);
        repository.save(entity);
        return modelMapper().map(entity, PostDTO.class);
    }

    @Override
    public void deletePost(PostDTO post) {
        Post entity = modelMapper().map(post, Post.class);
        repository.delete(entity);
    }
}
