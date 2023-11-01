package com.xfleetsolutions.pages;

import com.xfleetsolutions.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {

    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[text()='Add Event']")
    public WebElement addEventButton;

}
