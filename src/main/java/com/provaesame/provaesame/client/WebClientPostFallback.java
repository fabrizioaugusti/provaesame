package com.provaesame.provaesame.client;

import java.util.ArrayList;
import java.util.List;

import com.provaesame.provaesame.model.PostDTO;

public class WebClientPostFallback implements IWebClientPost {

    @Override
    public List<PostDTO> getPosts() {
        return new ArrayList<PostDTO>();
    }
    
}
