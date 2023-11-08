package com.xfleetsolutions.pages;

import com.xfleetsolutions.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class DeleteCarePage {

    public DeleteCarePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

        @FindBy(xpath = "(//table//td//div[@class='dropdown'])[1]")
        public WebElement threeDotsButton;


        @FindBy(xpath = "(//i[@class='fa-trash-o hide-text'])[1]")
        public WebElement deletePopUpIcon;


        @FindBy(xpath = "//div[@class='modal-header']")
        public WebElement deleteConfirmationPopUp;

        @FindBy(xpath = "//a[@class='btn ok btn-danger']")
        public WebElement yesDeleteButton;


        @FindBy(xpath = "//div[@class='message']")
        public WebElement permissionMassege ;





        //@FindBy(xpath = "//div[@class='flash-messages-holder']")
        //@FindBy(xpath = "//div[@class='message']")
        //@FindBy(xpath = "//div[@class='message'][text()='Item deleted']")
        @FindBy(xpath = "//div[text()='Item deleted']")
        public WebElement itemDeletedMessage;


        //Delete Confirmation


}
