package org.academiadecodigo.codezillas.insane.controllers;

import org.academiadecodigo.codezillas.insane.dtos.UserDto;
import org.academiadecodigo.codezillas.insane.dtos.UserDtoToUser;
import org.academiadecodigo.codezillas.insane.dtos.UserToUserDto;
import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.UserService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class CustomerController {

    private UserService userService;
    private boolean isMultipart;

    private UserToUserDto userToDto;
    private UserDtoToUser userDtoToUser;

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
    public void setUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
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
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/recruiter")
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {

       if (bindingResult.hasErrors()) {
            return "404";
       }

        //isMultipart = ServletFileUpload.isMultipartContent(user);
        //DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        userService.saveOrUpdate(userDtoToUser.user(userDto));
        //HttpSession httpSession =
        return "redirect:homepage";
    }



    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpSession session) {
        modelMap.addAttribute("file", file);
        //System.out.println("\n" + file.getSize()+ "----------------------\n");

        try {
            //ServletContext servletContext = session.getServletContext();
            //String path = servletContext.getRealPath("WEB-INF/template/");
            byte[] barr =file.getBytes();
            System.out.println(file.getOriginalFilename() + "----------------------");
            BufferedOutputStream bu = new BufferedOutputStream(new FileOutputStream(file.getOriginalFilename()));
            bu.write(barr);
            bu.flush();
            bu.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String sub(Model model){

        return "fileUploadView";
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String sub2(Model model){
        return "file";
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }
    /*

    @RequestMapping(method = RequestMethod.POST, path = {"//path"})
    public String login(@Valid @ModelAttribute("//path") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "//path";
        }

        User userLogged = userService.saveOrUpdate(userToDto.convert(user));

        redirectAttributes.addFlashAttribute("lastAction", "Logged in" + userLogged.getName() + " " + userLogged.getLastName);
        return "//path" + userLogged.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String homePage(@PathVariable Model model) {
        return "//path";
    }


    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String showAllUsers(Model model) {
        model.addAttribute("//path", UserToUserDto.convert(userService.list()));
        return "//path";
    }

    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String showUserById(@PathVariable Integer id, Model model) {

        User user = userService.findById(id);

        model.addAttribute("user", userToDto.convert(user));
        model.addAttribute("accountTypes", AccountType.list());

        return "//path";


    }*/


}
