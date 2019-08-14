package org.academiadecodigo.codezillas.insane.controllers;

import org.academiadecodigo.codezillas.insane.dtos.RecruiterDto;
import org.academiadecodigo.codezillas.insane.dtos.UserDto;
import org.academiadecodigo.codezillas.insane.dtos.UserDtoToUser;
import org.academiadecodigo.codezillas.insane.dtos.UserToUserDto;
import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class CustomerController {

    private UserService userService;

    private UserToUserDto userToDto;
    private UserDtoToUser userDtoToUser;
    private UserDtoToUser user;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserToDto(UserToUserDto userToDto) {
        this.userToDto = userToDto;
    }

    @Autowired
    public void setUserToUserDto(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }


    @Autowired
    public void setUser(UserDtoToUser user) {
        this.user = user;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/recruiter")
    public String recruiter(Model model) {
        model.addAttribute("user", new UserDto());
        //model.addAttribute("//path", userToDto.convert(userService.get(id)));
        return "recruiterForm";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/homepage")
    public String user(Model model) {

        Set<User> users = userService.getAll();
        List<User> list = new ArrayList<>(users);

        model.addAttribute("users", list);
        model.addAttribute("userLogin", new UserDto());
        model.addAttribute("recruiter", new RecruiterDto());
        model.addAttribute("userReg", new UserDto());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String login2(@ModelAttribute("userLogin") UserDto userDto){

        User user = userDtoToUser.user(userDto);

        if (user == null){
            return "404";
        }
        String password = user.getPassword();
        String email = user.getEmail();

        if (userService.authenticate(email, password)){
            System.out.println("+++++++++++++++++++++GG");
        }
        return "index";
    }

    private static final String UPLOAD_DIRECTORY ="/images";

    @RequestMapping(method = RequestMethod.POST, path = {"/recruiter"})
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {

       if (user == null){
           return "404";
       }
        userService.saveOrUpdate(userDtoToUser.user(userDto));

        return "redirect:homepage";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);

        String filename = file.getOriginalFilename();

        //System.out.println(path + " " + filename);
        try {
            byte[] barr = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(UPLOAD_DIRECTORY + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();
            //return "Upload";
        } catch (IOException ex) {

        }

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uploadFile")
    public String loadupload(Model model){
        return "upload";
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }

    /*@RequestMapping(method = RequestMethod.POST, path = {"/login"})
    public String login(@ModelAttribute("userLogin") UserDto userDto) {


        userService.saveOrUpdate(userDtoToUser.user(userDto));

        //redirectAttributes.addFlashAttribute("lastAction", "Logged in" + userLogged.getName() + " " + userLogged.getLastName);
        return "index";//+ userLogged.getId();
    }*/
/*
    @RequestMapping(method = RequestMethod.GET, path = "/path")
    public String homePage(@PathVariable Model model) {
        return "path";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/path")
    public String showAllUsers(Model model) {
        model.addAttribute("//path", userToDto.convert(userService.list()));
        return "path";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/path")
    public String showUserById(@PathVariable Integer id, Model model) {

        User user = userService.findById(id);

        model.addAttribute("user", userToDto.convert(user));
        model.addAttribute("accountTypes", AccountType.USER);

        return "path";
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/img/{image}")
    public String showImage(@PathVariable String name){
        
    }
}
