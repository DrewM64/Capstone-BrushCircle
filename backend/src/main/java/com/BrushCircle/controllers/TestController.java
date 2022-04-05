package com.BrushCircle.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TestController {
    /* this should store the path to your resources directory in which the upload folder will
    * be placed. */
    public static String uploadDirectory = System.getProperty("user.dir") + "/BrushCircleUploads";

    public TestController() {
    }

    @RequestMapping("/")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String echoResponse(){
        return "Hello Team 1";
    }

    @RequestMapping("/uploadview")
    public String UploadPage(Model model) {
        return "uploadview";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("file") MultipartFile file) throws IOException {
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        model.addAttribute("msg", "successfully uploaded file: " + file.getOriginalFilename());

        return "uploadstatusview";
    }

    @RequestMapping("/reactupload")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String[] ReactUpload(@RequestParam("file") MultipartFile file) throws IOException {
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename().replaceAll(" ", "-"));
        Files.write(fileNameAndPath, file.getBytes());

        File newFile = new File(uploadDirectory);
        String[] fileList = newFile.list();

        return fileList;
    }

    @RequestMapping("/testfilelist")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String[] GetFileList(){
        File tempFile = new File(uploadDirectory);
        String[] fileList = tempFile.list();

        return fileList;
    }

    @RequestMapping("/reactuploadprofileimage")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String ReactUploadProfileImage(@RequestParam("file") MultipartFile file) throws IOException {
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename().replaceAll(" ", "-"));
        Files.write(fileNameAndPath, file.getBytes());

        File newFile = new File(uploadDirectory);
        String[] fileList = newFile.list();

        return file.getOriginalFilename().replaceAll(" ", "-");
    }
}
