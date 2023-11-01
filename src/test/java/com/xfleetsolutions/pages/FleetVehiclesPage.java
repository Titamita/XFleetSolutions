package com.xfleetsolutions.pages;

import com.xfleetsolutions.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetVehiclesPage {

    public FleetVehiclesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filterButton;

    @FindBy(xpath = "//a[.='Manage filters']")
    public WebElement manageFilterButton;

    @FindBy(css = ".grid-row.row-click-action")
    public WebElement vehicleRow;

    @FindBy(xpath = "//table//tr[@class='grid-header-row']//input[@type='checkbox']")
    public WebElement toCheckAllCarsCheckbox;

    @FindBy(id = "ui-multiselect-0-0-option-1")
    public WebElement tagsCheckBox;

    @FindBy(id = "ui-multiselect-0-0-option-2")
    public WebElement driverCheckBox;

    @FindBy(id = "ui-multiselect-0-0-option-3")
    public WebElement locationCheckBox;
}
