package com.provaesame.provaesame.service;

import java.util.List;

import com.provaesame.provaesame.model.PostDTO;

public interface IPostService {
    public List<PostDTO> getAllPosts();
    public PostDTO createPost(PostDTO post);
    public PostDTO getPostById(int id);
    public PostDTO updatePost(PostDTO post);
    public void deletePost(PostDTO post);
}
