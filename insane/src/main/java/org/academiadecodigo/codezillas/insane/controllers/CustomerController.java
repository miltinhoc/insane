package org.academiadecodigo.codezillas.insane.controllers;

import org.academiadecodigo.codezillas.insane.AccountType;
import org.academiadecodigo.codezillas.insane.converters.UserDtoToUser;

import org.academiadecodigo.codezillas.insane.converters.UserToUserDto;
import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping
public class CustomerController {

    private UserService userService;

    private UserToUserDto userToDto;
    private UserDtoToUser user;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserToDto(UserToUserDto userToDto) {
        this.userToDto = userToDto;
    }


    /*@RequestMapping(method = RequestMethod.GET, path = {"//path"})
    public String recruiter(@PathVariable Integer id, Model model) {
        model.addAttribute("//path", userToDto.convert(userService.get(id)));
        return "//path";
    }*/

    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String user(@PathVariable Integer id, Model model) {
        model.addAttribute("//path", userToDto.convert(userService.findById(id)));
        return "//path";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"//path"})
    public String register(@Valid @ModelAttribute("//path") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "//path";
        }

        User registeredUser = userService.saveOrUpdate(userToDto.convert(user));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + registeredUser.getFirstName() + " " + registeredUser.getLastName());
        return "//path" + registeredUser.getId();
    }

    @RequestMapping(method = RequestMethod.POST, path = {"//path"})
    public String login(@Valid @ModelAttribute("//path") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "//path";
        }

        User userLogged = userService.saveOrUpdate(userToDto.convert(user));

        redirectAttributes.addFlashAttribute("lastAction", "Logged in" + userLogged.getFirstName() + " " + userLogged.getLastName());
        return "//path" + userLogged.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String homePage(@PathVariable Model model) {
        return "//path";
    }


    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String showAllUsers(Model model) {
        model.addAttribute("//path", UserToUserDto.convert(userService.findBySkill())); //TODO: lista de users
        return "//path";
    }

    @RequestMapping(method = RequestMethod.GET, path = "//path")
    public String showUserById(@PathVariable Integer id, Model model) {

        User user = userService.findById(id);

        model.addAttribute("user", userToDto.convert(user));
        model.addAttribute("accountTypes", AccountType.list());

        return "//path";


    }


}
