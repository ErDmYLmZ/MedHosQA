package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansCreateEditPage {

    public PhysiciansCreateEditPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="searchSSN")
    public WebElement ssnButton;

    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement searchUserButton;

    @FindBy(name="firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "phone")
    public WebElement phone;

    @FindBy(name = "adress")
    public WebElement address;

    @FindBy(name = "gender")
    public WebElement gender;

    @FindBy(name = "speciality")
    public WebElement speciality;

    @FindBy(name = "bloodGroup")
    public WebElement bloodGroup;

    @FindBy(name = "description")
    public WebElement description;

    @FindBy(name = "image")
    public WebElement image;

    @FindBy(name = "examFee")
    public WebElement examFee;

    @FindBy(name = "user.id")
    public WebElement user;

    @FindBy(name = "country.id")
    public WebElement country;

    @FindBy(name = "cstate.id")
    public WebElement state;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

}