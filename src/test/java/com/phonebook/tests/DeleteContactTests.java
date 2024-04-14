package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Emmanuel")
                .setLastName("Macron")
                .setPhone("1234567890")
                .setEmail(UserData.EMAIL)
                .setAddress("Paris")
                .setDescription("President"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactPositiveTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().click(By.cssSelector(".contact-item_card__2SOIM"));
        app.getContact().click(By.xpath("//button[.='Remove']"));

        app.getContact().pause(500);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}