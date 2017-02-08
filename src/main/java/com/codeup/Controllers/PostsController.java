package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    public String postIndex(Model model) {
        List<Post> list = new ArrayList<>();
        Post post1 = new Post();
        Post post2 = new Post();

        post1.setTitle("Post1 Title");
        post1.setBody("This is the body of post1.");
        post2.setTitle("Post2 Title");
        post2.setBody("This is the body of post2.");

        list.add(post1);
        list.add(post2);
        model.addAttribute("postList", list);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = new Post();

        post.setTitle("Post Title");
        model.addAttribute("postTitle", post.getTitle());

        post.setBody("This is a body of a post");
        model.addAttribute("postBody", post.getBody());
        return "show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPosts() {
        return "create a new post";
    }
}
