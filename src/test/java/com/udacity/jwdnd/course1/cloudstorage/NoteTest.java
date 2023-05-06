package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTest extends CloudstorageApplicationTests {

    @Test
    public void CreateUpdateNoteTest() throws InterruptedException {
        String noteTitle = "My Note";
        String noteDescription = "This is my note test.";
        HomePage homePage = getHomePage();
        createNote(noteTitle, noteDescription, homePage);
        Thread.sleep(2000);
        homePage.openNotesTab();
        homePage = new HomePage(driver);
        homePage.editNote();
        String modifiedNoteTitle = "Modified Note";
        homePage.modifyNoteTitle(modifiedNoteTitle);
        String modifiedNoteDescription = "This is my modified note.";
        homePage.modifyNoteDescription(modifiedNoteDescription);

        homePage.saveNoteChanges();
        homePage.openNotesTab();
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(modifiedNoteTitle, note.getNotetitle());
        Assertions.assertEquals(modifiedNoteDescription, note.getNotedescription());
        Thread.sleep(2000);
    }
    @Test
    public void DeleteNoteTest() throws InterruptedException {
        String noteTitle = "Note title";
        String noteDescription = "This is note to test.";
        HomePage homePage= getHomePage();
        assertEquals("Home", driver.getTitle());
        createNote(noteTitle,noteDescription,homePage);
        Thread.sleep(2000);
        homePage.openNotesTab();
        homePage = new HomePage(driver);
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(noteTitle, note.getNotetitle());
        Assertions.assertEquals(noteDescription, note.getNotedescription());
        deleteNote(homePage);
        Thread.sleep(2000);
        homePage.logout();
    }

    private void createNote(String noteTitle, String noteDescription, HomePage homePage) {
        homePage.openNotesTab();
        homePage.addNewNote();
        homePage.setNoteTitle(noteTitle);
        homePage.setNoteDescription(noteDescription);
        homePage.saveNoteChanges();
        homePage.openNotesTab();
    }
    private void deleteNote(HomePage homePage) {
        homePage.deleteNote();
    }

}
