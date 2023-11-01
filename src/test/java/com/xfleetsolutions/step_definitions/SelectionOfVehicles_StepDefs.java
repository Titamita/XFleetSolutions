package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SelectionOfVehicles_StepDefs extends BasePage {

    FleetVehiclesPage fleetVehiclesPage = new FleetVehiclesPage();

    @Then("user sees all the checkboxes are unchecked")
    public void user_sees_all_the_checkboxes_are_unchecked() {

        Assert.assertTrue(!fleetVehiclesPage.toCheckAllCarsCheckbox.isSelected());
    }


    @Then("user selects the first checkbox to check all the cars")
    public void userSelectsTheFirstCheckboxToCheckAllTheCars() {

        BrowserUtils.waitForVisibility(fleetVehiclesPage.toCheckAllCarsCheckbox,2);

        fleetVehiclesPage.toCheckAllCarsCheckbox.click();

        Assert.assertTrue(fleetVehiclesPage.toCheckAllCarsCheckbox.isSelected());

    }
}
