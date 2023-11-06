package com.xfleetsolutions.pages;

import com.xfleetsolutions.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//table//tr//input[@type='checkbox']")
    public List<WebElement> checkboxesForCarSelection;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement manageFilterSearchBox;

    @FindBy(xpath = "//input[@name='multiselect_0']")
    public List<WebElement> allFilterCheckBoxesAfterSearch;

    @FindBy(xpath ="//li[@class=\"active\"]/../li")
    public List<WebElement> tenOptionsOfFilter;

    @FindBy(xpath = "//ul[@class=\"nav-multilevel main-menu\"]/li[normalize-space(\"Fleet\")]")
    public WebElement fleet;

    //this must be pressed if this not pressed (class= "action btn mode-icon-only pressed")
    @FindBy(xpath = "//a[@title=\"Filters\"]")
    public WebElement enableFiltersButton;
    @FindBy(xpath = "(//span[@class=\"title title-level-2\"])[.=\"Vehicles\"]")
    public WebElement vehicles;

    @FindBy(className = "add-filter-button")
    public WebElement manageFilterBtn;
    //click
    @FindBy(xpath = "//input[@type =\"search\"]")
    public WebElement searchBox;
    //send keys
    @FindBy(xpath = "//input[@value =\"LastOdometer\"]")
    public WebElement lastOdometerChkbox;
    @FindBy(xpath = "//button[@class=\"btn dropdown-toggle\"]")

    public WebElement optionEnabler;
    @FindBy(xpath = "(//div[@class=\"filter-item oro-drop\"])[1]")
    public WebElement lastOdometerDropButton;

    @FindBy(xpath = "//label[@class=\"dib\"][3]")
    public WebElement resultRecords;

    @FindBy(xpath = "(//a[@class=\"dropdown-item choice-value\"])[1]")
    public WebElement allOptions;
    //The dropdown is html so i need all options
    @FindBy(xpath = "//a[.=\"between\"]")
    public WebElement between;
    @FindBy(xpath = "//a[.=\"not between\"]")
    public WebElement not_between;
    @FindBy(xpath = "//a[.=\"equals\"]")
    public WebElement equals;
    @FindBy(xpath = "//a[.=\"not equals\"]")
    public WebElement not_equals;
    @FindBy(xpath = "//a[.=\"more than\"]")
    public WebElement more_than;
    @FindBy(xpath = "//a[.=\"less than\"]")
    public WebElement less_than;
    @FindBy(xpath = "//a[.=\"equals or more than\"]")
    public WebElement equals_or_more_than;
    @FindBy(xpath = "//a[.=\"equals or less than\"]")
    public WebElement equals_or_less_than;
    @FindBy(xpath = "//a[.=\"is empty\"]")
    public WebElement is_empty;
    @FindBy(xpath = "//a[.=\"is not empty\"]")
    public WebElement is_not_empty;
    //10 elements here



    //Between filter module contains min value max value and update button
    //should accept numbers only
    @FindBy(xpath = "//div[@class=\"filter-start\"]/input")
    public WebElement betweenFilterStartValue;
    //should accept numbers only
    @FindBy(xpath = "//div[@class=\"filter-end\"]/input")
    public WebElement betweenFilterEndValue;
    //click
    @FindBy(xpath = "//button[@class=\"btn btn-primary filter-update\"]")
    public WebElement updateButton;
    @FindBy(xpath ="//span[@class=\"reset-filter\"]" )
    public WebElement resetButton;
    @FindBy(xpath = "//label[@class=\"dib\"][3]")
    public WebElement getResultRecords;

    @FindBy(xpath = "//input[@name=\"value\"]")
    public WebElement singleValueFilterBox;
    //rangeResultColumButton has sort function 1st click sort the smallest value ,2nd click sort max value
    @FindBy(xpath = "(//span[.=\"Last Odometer\"])[1]")
    public WebElement rangeResultColumnSortButton;
    @FindBy(xpath = "(//tr[@class=\"grid-row\"])[1]/td[7]")
    public WebElement topResultOnResultColumn;

}
