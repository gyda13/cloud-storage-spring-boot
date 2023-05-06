package com.udacity.jwdnd.course1.cloudstorage;



import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CredentialTest extends CloudstorageApplicationTests {

    public static final String URL = "https://github.com/gyda13";
    public static final String USERNAME = "gyda";
    public static final String PASSWORD = "123";
    public static final String EDIT_URL = "https://github.com/gyda13";
    public static final String EDIT_USERNAME = "gyda2";
    public static final String EDIT_PASSWORD = "1234";

    @Test
    public void CreateUpdateCredentialTest() throws InterruptedException {
        HomePage homePage = getHomePage();
        createAndVerifyCredential(URL, USERNAME, PASSWORD, homePage);
        Credentials credential = homePage.getFirstCredential();
        String firstEncryptedPassword = credential.getPassword();
        homePage.editCredential();
        String newUrl = EDIT_URL;
        String newCredentialUsername = EDIT_USERNAME;
        String newPassword = EDIT_PASSWORD;
        setCredentialFields(newUrl, newCredentialUsername, newPassword, homePage);
        homePage.saveCredentialChanges();
        homePage.navToCredentialsTab();
        Credentials modifiedCredential = homePage.getFirstCredential();
        Assertions.assertEquals(newUrl, modifiedCredential.getUrl());
        Assertions.assertEquals(newCredentialUsername, modifiedCredential.getUsername());
        String modifiedCredentialPassword = modifiedCredential.getPassword();
        Assertions.assertNotEquals(newPassword, modifiedCredentialPassword);
        Assertions.assertNotEquals(firstEncryptedPassword, modifiedCredentialPassword);
        homePage.deleteCredential();
        homePage.logout();
    }
    @Test
    public void deletionCredentialTest() throws InterruptedException {
        HomePage homePage = getHomePage();
        createCredential(URL, USERNAME, PASSWORD, homePage);
        Thread.sleep(2000);
        homePage.navToCredentialsTab();
        homePage = new HomePage(driver);
        Credentials credentials = homePage.getFirstCredential();
        Assertions.assertEquals(URL, credentials.getUrl());
        Assertions.assertEquals(USERNAME, credentials.getUsername());
        deleteCredential(homePage);
        Thread.sleep(2000);
        homePage.logout();
    }
    private void createAndVerifyCredential(String url, String username, String password, HomePage homePage) throws InterruptedException {
        createCredential(url, username, password, homePage);
        homePage.navToCredentialsTab();
        Credentials credential = homePage.getFirstCredential();
        Assertions.assertEquals(url, credential.getUrl());
        Assertions.assertEquals(username, credential.getUsername());
        Assertions.assertNotEquals(password, credential.getPassword());
    }

    private void createCredential(String url, String username, String password, HomePage homePage) throws InterruptedException {
        homePage.navToCredentialsTab();
        homePage.addNewCredential();
        setCredentialFields(url, username, password, homePage);
        homePage.saveCredentialChanges();
        homePage.navToCredentialsTab();
    }

    private void setCredentialFields(String url, String username, String password, HomePage homePage) {
        homePage.setCredentialUrl(url);
        homePage.setCredentialUsername(username);
        homePage.setCredentialPassword(password);
    }
    private void deleteCredential(HomePage homePage) {
        homePage.deleteCredential();
    }

}
