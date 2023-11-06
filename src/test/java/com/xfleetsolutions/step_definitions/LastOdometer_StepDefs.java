package com.xfleetsolutions.step_definitions;

import com.xfleetsolutions.pages.BasePage;
import com.xfleetsolutions.pages.FleetVehiclesPage;
import com.xfleetsolutions.utilities.BrowserUtils;
import com.xfleetsolutions.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class LastOdometer_StepDefs extends BasePage {
    FleetVehiclesPage fleetVehiclesPage = new FleetVehiclesPage();

    // ********************* <AC1>   **************************
    @And("user enables Filters  button")
    public void userEnablesFiltersButton() {
        if (!fleetVehiclesPage.enableFiltersButton.isSelected()) {
            fleetVehiclesPage.enableFiltersButton.click();
        }
        Assert.assertTrue(fleetVehiclesPage.manageFilterBtn.isDisplayed());
    }

    @And("user enters : Last Odometer in searchBox")
    public void userEntersLastOdometerInSearchBox() {
        fleetVehiclesPage.manageFilterBtn.click();
        fleetVehiclesPage.searchBox.sendKeys("Last Odometer");
        fleetVehiclesPage.lastOdometerChkbox.click();
        fleetVehiclesPage.manageFilterBtn.click();
    }

    @Then("user should see Last Odometer button on page")
    public void user_should_see_last_odometer_button_on_page() {
        Assert.assertTrue(fleetVehiclesPage.lastOdometerDropButton.isDisplayed());
    }
    // ********************* </AC1> **************************


    // ********************* <AC2> **************************
    @Then("user should see all options")
    public void userShouldSeeAllOptions(List<String> allReqOptions) {
        fleetVehiclesPage.lastOdometerDropButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetVehiclesPage.optionEnabler).click().perform();
        List<String> actOptions = new ArrayList<>();
        int index = 0;
        for (WebElement each : fleetVehiclesPage.tenOptionsOfFilter
        ) {
            actOptions.add(each.getText());
            System.out.println(each.getText());
            Assert.assertEquals(each.getText(), allReqOptions.get(index));
            index++;
        }

    }


    // ********************* </AC2> **************************


    // ********************* <AC3> **************************

    @And("I enter the value into the {string} and {string} in filter:")
    public void iEnterTheValueIntoTheAndInFilter(String min, String max) {

        fleetVehiclesPage.lastOdometerDropButton.click();
        fleetVehiclesPage.betweenFilterStartValue.click();
        fleetVehiclesPage.betweenFilterStartValue.sendKeys(min);
        fleetVehiclesPage.betweenFilterEndValue.click();
        fleetVehiclesPage.betweenFilterEndValue.sendKeys(max);
        fleetVehiclesPage.updateButton.click();
    }

    @Then("the page should only contain results in range of{string} and {string}")
    public void thePageShouldOnlyContainResultsInRangeOfAnd(String min, String max) {


        BrowserUtils.waitFor(2);
        fleetVehiclesPage.rangeResultColumnSortButton.click(); //sorts min   may require wait

        String range1ClickSort = fleetVehiclesPage.topResultOnResultColumn.getText();
        fleetVehiclesPage.rangeResultColumnSortButton.click(); //sort max;
        BrowserUtils.waitFor(2);
        String range2ClickSort = fleetVehiclesPage.topResultOnResultColumn.getText();
        int actMin = BrowserUtils.parseIntWithComma(range1ClickSort);
        int actMax = BrowserUtils.parseIntWithComma(range2ClickSort);


        int expMin = Integer.parseInt(min);
        int extMax = Integer.parseInt(max);

        fleetVehiclesPage.lastOdometerDropButton.click();
        fleetVehiclesPage.resetButton.click();

        Assert.assertTrue(actMin >= expMin);
        Assert.assertTrue(actMax <= extMax);

    }


    // ********************* </AC3> **************************

    // ********************* <AC4> **************************


    @And("user selects any of the filter {string} and enters any  non-digit {string} in filter range fields")
    public void userSelectsAnyOfTheFilterAndEntersAnyNonDigitInFilterRangeFields(String filterOptions, String data) {

        fleetVehiclesPage.lastOdometerDropButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetVehiclesPage.optionEnabler).click().perform();
        String initialRecords = fleetVehiclesPage.resultRecords.getText();

        switch (filterOptions) {
            case "Between":
                fleetVehiclesPage.between.click();
                fleetVehiclesPage.betweenFilterStartValue.sendKeys(data);
                fleetVehiclesPage.betweenFilterEndValue.sendKeys("123" + data);
                fleetVehiclesPage.updateButton.click();
                String actualRecord = fleetVehiclesPage.resultRecords.getText();
                Assert.assertEquals(initialRecords, actualRecord);

                break;

            case "Equals":
                fleetVehiclesPage.equals.click();
                fleetVehiclesPage.singleValueFilterBox.sendKeys(data);
                fleetVehiclesPage.updateButton.click();
                String actEqualRecord = fleetVehiclesPage.resultRecords.getText();
                Assert.assertEquals(initialRecords, actEqualRecord);

                break;
            case "More Than":
                fleetVehiclesPage.more_than.click();
                fleetVehiclesPage.singleValueFilterBox.sendKeys(data);
                fleetVehiclesPage.updateButton.click();
                String actualMoreRecord = fleetVehiclesPage.resultRecords.getText();
                Assert.assertEquals(initialRecords, actualMoreRecord);

                break;
            case "Less Than":
                fleetVehiclesPage.less_than.click();
                fleetVehiclesPage.singleValueFilterBox.sendKeys(data);
                fleetVehiclesPage.updateButton.click();
                String actualLessRecord = fleetVehiclesPage.resultRecords.getText();
                Assert.assertEquals(initialRecords, actualLessRecord);
                break;
        }
    }


    // ********************* </AC4> **************************

}
