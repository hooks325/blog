package com.codeup.services;

import com.codeup.models.Post;
import org.springframework.asm.Label;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/8/17.
 */
@Service("postService")
public class PostSvc {
    private List<Post> posts = new ArrayList<>();

    public PostSvc() {
        createPost();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(int id) {
        return posts.get(id - 1);
    }

    public Post save(Post post) {
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }

    private void createPost() {
        for (int i = 0; i < 50; i++) {
            save(new Post(i+1, "Title " + (i+1), "Body " + (i+1)));
        }
    }
}
