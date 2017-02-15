package com.codeup.Controllers;

import com.codeup.SecurityConfiguration;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
import com.codeup.repositories.Users;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class PostsController {
    private Users userRepository;
    private PasswordEncoder encoder;

    @Autowired
    PostSvc postService;

    @Autowired
    Posts postsDao;

    @Autowired
    public PostsController(Users userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("posts", Collections.emptyList());

        return "/posts/index";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retieveAllPosts(){
        return (List<Post>) postsDao.findAll();
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
    public String createPosts(@Valid Post post, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        model.addAttribute("post", postsDao.findOne(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}")
    public String deletePost(@ModelAttribute Post post, @PathVariable long id) {
        postsDao.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/posts/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "/posts/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user,  Errors validation, Model model, @RequestParam(name = "password_confirm") String passwordconfirmation){
        if (!passwordconfirmation.equals(user.getPassword())) {
            validation.rejectValue("password", "user.password", "Your passwords do not match");
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "/posts/register";
        }

        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "redirect:/login";
    }


}
