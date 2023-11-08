package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.DeleteCarePage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteCar_StepDefs {

    DeleteCarePage deleteCarePage = new DeleteCarePage();


    @Then("user hovers over the three dots at the end of each row and sees delete icon appear")
    public void userHoversOverTheThreeDotsAtTheEndOfEachRowAndSeesDeleteIconAppear() {
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(3);
        actions.moveToElement(deleteCarePage.threeDotsButton).perform();
        Assert.assertTrue(deleteCarePage.deletePopUpIcon.isDisplayed());
    }


    @And("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        deleteCarePage.deletePopUpIcon.click();
    }

    @Then("Delete Confirmation pop-up is displayed")
    public void deleteConfirmationPopUpIsDisplayed() {
        deleteCarePage.deleteConfirmationPopUp.isDisplayed();
    }


    @And("the user confirms deletion by clicking on {string} button")
    public void theUserConfirmsDeletionByClickingOnButton(String arg0) {
        deleteCarePage.yesDeleteButton.click();

    }

    @Then("a {string} message is displayed")
    public void aMessageIsDisplayed(String arg0) {
        String expectedMassege = "You do not have permission to perform this action." ;
                String actualMassege = deleteCarePage.permissionMassege.getText() ;
                Assert.assertEquals(actualMassege, expectedMassege);
    }


    @Then("an {string} message is displayed")
    public void anMessageIsDisplayed(String arg0) {
        String expectedMassege = "Item deleted" ;
        String actualMassege = deleteCarePage.itemDeletedMessage.getText() ;
        Assert.assertEquals(actualMassege, expectedMassege);

    }
}








