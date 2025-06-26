package com.provaesame.provaesame.repository;

import org.springframework.stereotype.Repository;

import com.provaesame.provaesame.entity.Post;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
