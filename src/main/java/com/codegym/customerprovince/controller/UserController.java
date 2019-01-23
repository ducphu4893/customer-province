package com.codegym.customerprovince.controller;

import com.codegym.customerprovince.model.Province;
import com.codegym.customerprovince.model.User;
import com.codegym.customerprovince.service.ProvinceService;
import com.codegym.customerprovince.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("province")
    public Iterable<Province> provinces(){
        return provinceService.findAall();
    }

    @GetMapping("/create-user")
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("User/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@ModelAttribute("user")User user){
        userService.save(user);

        ModelAndView modelAndView = new ModelAndView("User/create");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("message","created successfully");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showListUser(@RequestParam("s") Optional<String>s,Pageable pageable){
        Page<User> users;
        if (s.isPresent()){
            users = userService.findAllByFirstNameContaining(s.get(),pageable);
        }else{
            users = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("User/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView("User/edit");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @PostMapping("/edit-user/{id}")
    public ModelAndView updateUser(@ModelAttribute("user")User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("User/edit");
        modelAndView.addObject("user",user);
        modelAndView.addObject("message","updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView shoeDeleteForm(@PathVariable int id){
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView("User/delete");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @PostMapping("delete-user")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.remove(user.getId());
        return "redirect:users";
    }
}
