package com.provaesame.provaesame.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.provaesame.provaesame.model.PostDTO;

@FeignClient(value = "postHolder", url = "https://jsonplaceholder.typicode.com/", fallback = WebClientPostFallback.class)
public interface IWebClientPost {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<PostDTO> getPosts();
    
}
