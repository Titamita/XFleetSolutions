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

    @FindBy(xpath = "//input[@name='multiselect_0']/following-sibling::span")
    public List<WebElement> allFilterCheckBoxesAfterSearch;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement tagsFilterOption;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement isAnyOfButton;

    @FindBy(xpath = "//a[@class='dropdown-item choice-value']")
    public List<WebElement> isAnyOfFilterOptions;

    @FindBy(id = "s2id_autogen2")
    public WebElement isAnyOfInputTextBox;

    @FindBy(xpath = "//div[.='Compact']")
    public WebElement compactOption;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr/td/ul/li[.='Compact']")
    public List<WebElement> compactTagsResult;

    @FindBy(xpath = "(//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr/td/ul/li[.='Compact'])[1]")
    public WebElement compactFirstRowResult;

}
