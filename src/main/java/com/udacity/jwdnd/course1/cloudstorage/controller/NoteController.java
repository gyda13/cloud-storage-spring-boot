package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@RequestMapping("/home/notes")
@Controller
public class NoteController {

    private NoteService noteService;
    private UserMapper userMapper;

    public NoteController(NoteService noteService, UserMapper userMapper) {
        this.noteService = noteService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public String AddUpdateNote(Authentication authentication, Note note, RedirectAttributes redirectAttributes){
        String loggedInUserName = (String) authentication.getPrincipal();
        User user = userMapper.getUser(loggedInUserName);
        Integer userId = user.getUserId();

        if (note.getNoteid() != null) {
            noteService.updateNote(note);
            redirectAttributes.addFlashAttribute("infoMessage", "Your Note were updated successfully");

        } else {
            noteService.addNote(note, userId);
            redirectAttributes.addFlashAttribute("successMessage", "Your Note were created successfully");

        }

        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam("id") int noteid, RedirectAttributes redirectAttributes){
        if(noteid > 0){
            noteService.deleteNote(noteid);
            redirectAttributes.addFlashAttribute("actionMessage", "Your Note were deleted.");
            return "redirect:/home";
        }


        redirectAttributes.addFlashAttribute("errorMessage", "Unable to delete the note.");
        return "redirect:/home";
    }
}
