package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.AddEventPage;
import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEvent_CompulsoryField_StepDefs extends BasePage {

    FleetVehiclesPage fp = new FleetVehiclesPage();
    AddEventPage ae = new AddEventPage();
    Actions actions = new Actions(Driver.getDriver());

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @When("user hover over on Fleet button and click Vehicle button")
    public void user_hover_over_on_fleet_button_and_click_vehicle_button() {

        wait.until(ExpectedConditions.visibilityOf(fleetButton));

        actions.moveToElement(fleetButton).perform();
        vehicle.click();

    }

    @When("click on vehicle row")
    public void click_on_vehicle_row() {

        fp.vehicleRow.click();

    }

    @Then("user should access the Add Event page")
    public void user_should_access_the_add_event_page() {

        Assert.assertTrue(ae.generalInfo.isDisplayed());

    }

    @Then("{string} can click Add Event button, but driver can NOT see Add Event button")
    public void can_click_add_event_button_but_driver_can_not_see_add_event_button(String user) {
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

        ae.addEventButton.click();

    }

    @Then("Add Event page should pop up")
    public void add_event_page_should_pop_up() {

        wait.until(ExpectedConditions.visibilityOf(ae.addEventPopUp));
        Assert.assertTrue(ae.addEventPopUp.isDisplayed());

    }


}
