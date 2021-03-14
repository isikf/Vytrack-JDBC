package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    Pages pages = new Pages();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} credentials")
    public void the_user_enters_credentials(String userType){
        String userName= null;
        String password= null;

        if (userType.equals("driver")) {
            userName= ConfigurationReader.get("driver_username");
            password= ConfigurationReader.get("driver_password");
        }   else if (userType.equals("store manager")) {
            userName= ConfigurationReader.get("store_manager_username");
            password= ConfigurationReader.get("store_manager_password");
        }   else if (userType.equals("sales manager")) {
            userName= ConfigurationReader.get("sales_manager_username");
            password= ConfigurationReader.get("sales_manager_password");
        }
        pages.loginPage().login(userName, password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        pages.loginPage().waitUntilLoaderScreenDisappear();
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify title is Dashboard", "Dashboard", actualTitle);
    }

}
