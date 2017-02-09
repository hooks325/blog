package com.codeup.Controllers;

import com.codeup.models.Post;
import com.codeup.repositories.Posts;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class PostsController {

    @Autowired
    PostSvc postService;

    @Autowired
    Posts postsDao;

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post onePost = postsDao.findOne(id);
        model.addAttribute("post", onePost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreate(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPosts( @ModelAttribute Post post, Model model) {
        postsDao.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post, Model model, @PathVariable long id){
        model.addAttribute("post", postsDao.findOne(id));
        return "/posts/edit";
    }
}
