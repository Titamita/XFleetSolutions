package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleFilter_StepDefs extends BasePage {

    FleetVehiclesPage fleetVehiclesPage = new FleetVehiclesPage();


    @Given("user clicks on Fleet Module and select Vehicles from dropdown")
    public void user_clicks_on_fleet_module_and_select_vehicles_from_dropdown() {

        navigateToModule("Fleet", "Vehicles");

    }

    @Given("user clicks on Filter icon")
    public void user_clicks_on_filter_icon() {

        BrowserUtils.sleep(3);
        //BrowserUtils.waitForClickablility(By.xpath("//a[@title='Filters']"), 20);

        fleetVehiclesPage.filterButton.click();


    }

    @Then("Manage Filter button should be visible")
    public void manage_filter_button_should_be_visible() {

        Assert.assertTrue(fleetVehiclesPage.manageFilterButton.isDisplayed());

    }

    @Given("user clicks on Manage Filter button")
    public void user_clicks_on_manage_filter_button() {

        BrowserUtils.waitForVisibility(fleetVehiclesPage.manageFilterButton, 10);

        fleetVehiclesPage.manageFilterButton.click();

    }

    @When("user can select any {string} from dropdown options")
    public void user_can_select_any_from_dropdown_options(String checkbox) {

        switch (checkbox) {
            case "Tags":
                fleetVehiclesPage.tagsCheckBox.click();
                BrowserUtils.waitForVisibility(fleetVehiclesPage.tagsCheckBox, 5);
                Assert.assertTrue(fleetVehiclesPage.tagsCheckBox.isSelected());
                break;
            case "Driver":
                fleetVehiclesPage.driverCheckBox.click();
                BrowserUtils.waitForVisibility(fleetVehiclesPage.driverCheckBox, 5);
                Assert.assertTrue(fleetVehiclesPage.driverCheckBox.isSelected());
                break;
            case "Location":
                fleetVehiclesPage.locationCheckBox.click();
                BrowserUtils.waitForVisibility(fleetVehiclesPage.locationCheckBox, 5);
                Assert.assertTrue(fleetVehiclesPage.locationCheckBox.isSelected());
        }

    }

    @Then("user type {string} in the Manage Filter search box")
    public void user_type_in_the_manage_filter_search_box(String filterName) {

        fleetVehiclesPage.manageFilterSearchBox.sendKeys(filterName);
    }

    @When("user should see {string} as available filter")
    public void user_should_see_as_available_filter(String expectedFilterName) {

        List<WebElement> actualFilterCheckboxes = fleetVehiclesPage.allFilterCheckBoxesAfterSearch;

        for (WebElement each : actualFilterCheckboxes) {

            String actualCheckboxText = each.getAttribute("title");

            //System.out.println("Actual checkbox text: " + actualCheckboxText);

            if (actualCheckboxText.contains(expectedFilterName)) {

                Assert.assertEquals(expectedFilterName, actualCheckboxText);
                break;
            }
        }


    }

    @Then("Manage Filter should contain the following filters")
    public void manageFilterShouldContainTheFollowingFilters(List<String> expectedCheckboxes) {

        BrowserUtils.waitForVisibility(By.xpath("//input[@name='multiselect_0']"), 15);

        List<String> actualCheckboxes = new ArrayList<>();

        for (WebElement each : fleetVehiclesPage.allFilterCheckBoxesAfterSearch) {

            actualCheckboxes.add(each.getText());

        }

        //System.out.println(actualCheckboxes);

        Assert.assertEquals(expectedCheckboxes, actualCheckboxes);

    }

    @When("user select Tags filter from dropdown option")
    public void userSelectTagsFilterFromDropdownOption() {

        fleetVehiclesPage.tagsCheckBox.click();
    }

    @And("user clicks on Tags All filter")
    public void userClicksOnTagsAllFilter() {

        BrowserUtils.waitForClickablility(fleetVehiclesPage.tagsFilterOption, 15);

        fleetVehiclesPage.tagsFilterOption.click();
    }

    @Then("Tags filter should provide the methods in a dropdown option as shown below")
    public void tagsFilterShouldProvideTheMethodsInADropdownOptionAsShownBelow(List<String> expectedFilterOptions) {

        fleetVehiclesPage.isAnyOfButton.click();

        //waitForVisibility for List of WebElement ==> called 'isAnyOfFilterOptions' in FleetVehiclesPage
        BrowserUtils.waitForVisibility(By.xpath("//a[@class='dropdown-item choice-value']"), 20);


        List<String> actualFilterOptions = new ArrayList<>();

        for (WebElement each : fleetVehiclesPage.isAnyOfFilterOptions) {

            actualFilterOptions.add(each.getText());

        }


        Assert.assertEquals(expectedFilterOptions, actualFilterOptions);

    }

}

