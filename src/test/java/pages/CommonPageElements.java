package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPageElements {

    public CommonPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement signInAndRegistrationPortal;

    @FindBy(id="login-item")
    public WebElement signIn;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement titlesAllUsers;

    @FindBy(partialLinkText = "Items&Titles")
    public WebElement itemsAndTitles;

    @FindBy(partialLinkText = "Staff")
    public WebElement staff;

    @FindBy(partialLinkText = "Settings")
    public WebElement settings;







    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsButton;
}
