package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Given("user clicks on Manage Filter button")
    public void user_clicks_on_manage_filter_button() {

        fleetVehiclesPage.manageFilterButton.click();

    }
    @When("user can select any {string} from dropdown options")
    public void user_can_select_any_from_dropdown_options(String checkbox) {

        switch (checkbox) {
            case "Tags":
                fleetVehiclesPage.tagsCheckBox.click();
                Assert.assertTrue(fleetVehiclesPage.tagsCheckBox.isSelected());
                break;
            case "Driver":
                fleetVehiclesPage.driverCheckBox.click();
                Assert.assertTrue(fleetVehiclesPage.driverCheckBox.isSelected());
                break;
            case "Location":
                fleetVehiclesPage.locationCheckBox.click();
                Assert.assertTrue(fleetVehiclesPage.locationCheckBox.isSelected());
        }

    }
}
