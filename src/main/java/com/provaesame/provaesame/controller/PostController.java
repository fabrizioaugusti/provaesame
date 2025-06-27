package com.provaesame.provaesame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provaesame.provaesame.model.PostDTO;
import com.provaesame.provaesame.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

   

    @GetMapping("")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("Rest posts ok");
    }

    @Operation(summary = "Recupera post", description = "Metodo per recuperare i post dall'esterno")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista recuperata", content = @Content(schema = @Schema(implementation = PostDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nessuna lista trovata"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })
    @GetMapping("/retrieveAndSave")
    public ResponseEntity<List<PostDTO>> retrievePosts() {
       
        service.retrievePostsFromWeb();
        List<PostDTO> posts = service.getAllPosts();
        if (posts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/retrieveFromWeb")
    public ResponseEntity<List<PostDTO>> retrieveFromWeb() {
       
        List<PostDTO> posts = service.getPostsFromWeb();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/retrieveFromDB")
    public ResponseEntity<List<PostDTO>> retrieveFromDB() {
       
        List<PostDTO> posts = service.getAllPosts();
        return ResponseEntity.ok(posts);
    }
}