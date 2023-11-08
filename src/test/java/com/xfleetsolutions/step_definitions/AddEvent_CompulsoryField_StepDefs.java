package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.AddEventPage;
import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddEvent_CompulsoryField_StepDefs extends BasePage {

    FleetVehiclesPage fp = new FleetVehiclesPage();
    AddEventPage ae = new AddEventPage();
    Actions actions = new Actions(Driver.getDriver());

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @When("user hover over on Fleet button and click Vehicle button")
    public void user_hover_over_on_fleet_button_and_click_vehicle_button() {

        waitUntilLoaderScreenDisappear();

        wait.until(ExpectedConditions.visibilityOf(fleetButton));

        actions.moveToElement(fleetButton).perform();
        vehicle.click();

    }

    @When("click on vehicle row")
    public void click_on_vehicle_row() {

        waitUntilLoaderScreenDisappear();
        fp.vehicleRow.click();

    }

    @Then("user should access the Add Event page")
    public void user_should_access_the_add_event_page() {

        waitUntilLoaderScreenDisappear();
        Assert.assertTrue(ae.generalInfo.isDisplayed());

    }

    @Then("{string} can click Add Event button, but driver can NOT see Add Event button")
    public void can_click_add_event_button_but_driver_can_not_see_add_event_button(String user) {

        waitUntilLoaderScreenDisappear();

        BrowserUtils.sleep(3);
        if (user.equals("sales manager") || user.equals("store manager")) {
            Assert.assertTrue(ae.addEventButton.isDisplayed());
        }

        if (user.equals("driver")) {
            Assert.assertFalse(ae.addEventButton.isDisplayed());
        }

    }

    @When("{string} click Add Event button")
    public void click_add_event_button(String user) {

        waitUntilLoaderScreenDisappear();
        ae.addEventButton.click();

    }

    @Then("Add Event page should pop up")
    public void add_event_page_should_pop_up() {

        waitUntilLoaderScreenDisappear();
        wait.until(ExpectedConditions.visibilityOf(ae.addEventPopUp));
        Assert.assertTrue(ae.addEventPopUp.isDisplayed());
        ae.closeButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("Compulsory fields are shown in certain order: {string}")
    public void compulsory_fields_are_shown_in_certain_order(String user, List<String> expectedReqFields) {

        wait.until(ExpectedConditions.visibilityOf(ae.addEventPopUp));

        List<String> actualReqFields = new ArrayList<>();

        for (WebElement each : ae.requiredFields) {

            actualReqFields.add(each.getText().replace("*", ""));

        }
        Assert.assertEquals(expectedReqFields, actualReqFields);

        ae.closeButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("if any compulsory field is not filled, {string} message should be displayed after clicking on save button")
    public void if_any_compulsory_field_is_not_filled_message_should_be_displayed_after_clicking_on_save_button(String expectedMessage) {

        waitUntilLoaderScreenDisappear();

        // All fields empty, user click on save
        ae.saveButton.click();
        String actualMessage = ae.errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        // User fill just Title field, other compulsory fields are empty
        ae.titleField.sendKeys("Honda");
        ae.saveButton.click();

        Assert.assertTrue(ae.addEventPopUp.isDisplayed());

        ae.closeButton.click();
        BrowserUtils.sleep(2);

    }


}
