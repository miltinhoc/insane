package org.academiadecodigo.codezillas.insane.controllers;

import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

@Controller
@RequestMapping
public class UploadController {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;



    @RequestMapping(method = RequestMethod.GET, path = "/uploadimage")
    public String doPost() {

        return "loadimage";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/sendimage")
    public String saveImage(@ModelAttribute ("file") File file) {

        try {
            FileInputStream input = new FileInputStream(file);

            System.out.println(input.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    return  doPost();
    }


}
