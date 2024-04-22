package com.tbp.crud.controller;

import com.tbp.crud.entity.BlogPost;
import com.tbp.crud.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost savedPost = blogPostRepository.save(blogPost);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost post = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> posts = blogPostRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedPost) {
        BlogPost existingPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBody(updatedPost.getBody());
        existingPost.setAuthor(updatedPost.getAuthor());

        BlogPost savedPost = blogPostRepository.save(existingPost);
        return ResponseEntity.ok(savedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
