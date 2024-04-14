package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositiveTest() {


        //click on login link
        app.getUser().clickOnLoginLink();
        //fill login form
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on registration button
        app.getUser().clickOnRegistrationButton();
        //check that sign out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
