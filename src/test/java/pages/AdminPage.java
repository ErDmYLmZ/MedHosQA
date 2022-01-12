package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPage {
    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Admin Page Elements

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//*[text()='Users']")
    public WebElement usersPageText;

    @FindBy(xpath = "//*[text()='Create a new user']")
    public WebElement createANewUser;

    @FindBy(xpath = "//*[text()='View']")
    public WebElement viewButton;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement titlesDropdown;

    @FindBy(xpath = "//*[text()='Patients']")
    public WebElement patient;

    @FindBy(xpath = "//*[text()='Staff']")
    public WebElement staff;

    @FindBy(xpath = "//*[text()='Physician']")
    public WebElement physician;

    @FindBy(xpath = "//*[text()='Appointment']")
    public WebElement appointment;

    @FindBy(xpath = "//*[text()='Test Item']")
    public WebElement testItem;

    @FindBy(xpath = "//*[text()='Room']")
    public WebElement room;

    @FindBy(xpath = "//*[text()='Country']")
    public WebElement country;

    @FindBy(xpath = "//*[text()='State /City']")
    public WebElement stateCity;

    @FindBy(xpath = "//*[text()='Messages']")
    public WebElement messages;

}
