package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VehicleFilter_StepDefs extends BasePage{

    FleetVehiclesPage fleetVehiclesPage = new FleetVehiclesPage();


    @Given("user clicks on Fleet Module and select Vehicles from dropdown")
    public void user_clicks_on_fleet_module_and_select_vehicles_from_dropdown() {

        navigateToModule("Fleet", "Vehicles");

    }
    @Given("user clicks on Filter icon")
    public void user_clicks_on_filter_icon() {

        fleetVehiclesPage.filterButton.click();


    }
    @Then("Manage Filter button should be visible")
    public void manage_filter_button_should_be_visible() {

        Assert.assertTrue(fleetVehiclesPage.manageFilterButton.isDisplayed());

    }
}
