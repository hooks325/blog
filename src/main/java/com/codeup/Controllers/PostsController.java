package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String postIndex() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId() {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    public String postCreate() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPosts() {
        return "create a new post";
    }
}
