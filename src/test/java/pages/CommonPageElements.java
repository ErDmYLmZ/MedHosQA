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

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement register;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement titlesAllUsers;

    @FindBy(partialLinkText = "Items&Titles")
    public WebElement itemsAndTitles;

    @FindBy(partialLinkText = "Staff")
    public WebElement staff;

    @FindBy(partialLinkText = "Settings")
    public WebElement settings;


    @FindBy(xpath = "//*[contains(text(),'Password')]")
    public WebElement Passwordbutton;
    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement currentPasswordBox;
    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement newPasswordBox;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement confirmPasswordBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement ToastifyMessage;




    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsButton;

    @FindBy(xpath = "//*[text()='Physician']")
    public WebElement physician;
}
