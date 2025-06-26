package com.provaesame.provaesame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.provaesame.provaesame.client.IWebClientPost;
import com.provaesame.provaesame.model.PostDTO;

@Service
public class WebClientPostService {
    
    @Autowired
    private IWebClientPost addressClient;

    public List<PostDTO> getPosts() {

        List<PostDTO> addressResponse = addressClient.getPosts();

        return addressResponse;
    }
}
