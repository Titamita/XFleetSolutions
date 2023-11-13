package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.LoginPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Login to app in Before method");
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("driver")){
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        }else if(userType.equalsIgnoreCase("sales manager")){
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        }else if(userType.equalsIgnoreCase("store manager")){
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }
        //send username and password and login
        new LoginPage().login(username,password);
    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {

      loginPage.login(username,password);
    }


    @When("the user login with {string} and {string}")
    public void theUserLoginWithAnd(String username, String password) {

        loginPage.login(username, password);

    }

    @Then("user should not be able to log in")
    public void userShouldNotBeAbleToLogIn() {

        BrowserUtils.verifyTitle("Login");

        String expectedErrorMessage = "Invalid user name or password.";
        String actualErrorMessage = loginPage.invalidUsernameOrPasswordErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }
}
