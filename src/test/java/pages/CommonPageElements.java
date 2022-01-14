package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CommonPageElements {

    public CommonPageElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement signInAndRegistrationPortal;

    @FindBy(id = "login-item")
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





    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsButton;


    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPages;

    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[text()='Physician']")
    public WebElement physician;

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationDropdown;
    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;
    @FindAll({@FindBy(xpath = "//*[text()='Edit']")})
    public List<WebElement> editButtons;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[2]")})
    public List<WebElement> userNames;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[3]")})
    public List<WebElement> userSSNs;


    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;


    @FindAll({@FindBy(xpath = "//a[@class='page-link']")})
    public List<WebElement> paginations;



    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement registrationTab;
}
