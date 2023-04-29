package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class HomeController {

    private FileService fileService;

    private CredentialService credentialService;

    private UserService userService;

    private NoteService noteService;

    private EncryptionService encryptionService;

    public HomeController(FileService fileService, CredentialService credentialService, UserService userService, NoteService noteService, EncryptionService encryptionService) {
        this.fileService = fileService;
        this.credentialService = credentialService;
        this.userService = userService;
        this.noteService = noteService;
        this.encryptionService = encryptionService;
    }

    @GetMapping()
    public String homeView(Model model, RedirectAttributes redirectAttributes, Authentication authentication){
        String username = authentication.getName();
        User user =userService.getUser(username);
        if(user==null || username==null ){
            redirectAttributes.addFlashAttribute("errorMessage","Please login first");
            return "redirect:/login";
        }else {
            int userId = user.getUserId();
            model.addAttribute("files", fileService.getUploadedFiles(userId));
            model.addAttribute("notes", noteService.getNotes(userId));
            model.addAttribute("credentials", credentialService.getCredentials(userId));
            model.addAttribute("encryptionService", encryptionService);
            return "home";
        }
    }

}