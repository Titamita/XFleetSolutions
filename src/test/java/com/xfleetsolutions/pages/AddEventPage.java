package com.xfleetsolutions.pages;

import com.xfleetsolutions.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEventPage {

    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[text()='Add Event']")
    public WebElement addEventButton;

    @FindBy(xpath = "//span[text()='General Information']")
    public WebElement generalInfo;

    @FindBy(xpath = "//span[text()='Add Event']")
    public WebElement addEventPopUp;

    @FindBy(xpath = "//label[@class='required']")
    public List<WebElement> requiredFields;


}
