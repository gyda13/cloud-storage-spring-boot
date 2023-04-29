package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping("/home/credentials")
public class CredentialController {
    private CredentialService credentialsService;
    private UserMapper userMapper;

    public CredentialController(CredentialService credentialsService, UserMapper userMapper) {
        this.credentialsService = credentialsService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public String AddUpdateCredentials(Authentication authentication, Credentials credentials, RedirectAttributes redirectAttributes){
        String loggedInUserName = (String) authentication.getPrincipal();
        User user = userMapper.getUser(loggedInUserName);
        Integer userId = user.getUserId();

        if (credentials.getCredentialid() != null) {
            credentialsService.editCredentials(credentials);
            redirectAttributes.addFlashAttribute("infoMessage", "Your credentials were updated successfully");
        } else {
            credentialsService.addCredentials(credentials, userId);
            redirectAttributes.addFlashAttribute("successMessage", "Your credentials were created successfully");
        }

        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteCredentials(@RequestParam("id") int credentialId, Authentication authentication, RedirectAttributes redirectAttributes){
        String loggedInUserName = (String) authentication.getPrincipal();
        User user = userMapper.getUser(loggedInUserName);

        if(credentialId > 0){
            credentialsService.deleteCredentials(credentialId);
            redirectAttributes.addFlashAttribute("actionMessage", "Your credentials were deleted.");
            return "redirect:/home";
        }

        redirectAttributes.addFlashAttribute("errorMessage", "Unable to delete the credentials.");
        return "redirect:/home";
    }
}