package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffPage {

    public StaffPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Create a new Staff")
    public WebElement createANewStaff;

    @FindBy(id = "searchSSN")
    public WebElement ssnTextbox;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchUserbutton;

    @FindBy(id = "useSSNSearch")
    public WebElement useSearchCheckBox;

    @FindBy(id = "staff-firstName")
    public WebElement firstNameTextbox;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement toastifSuccess;

    @FindBy(id = "staff-lastName")
    public WebElement lastNameTextbox;

    @FindBy(id = "staff-birthDate")
    public WebElement birthDateTextbox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneTextbox;

    @FindBy(id = "staff-gender")
    public WebElement genderDropbox;

    @FindBy(id = "staff-bloodGroup")
    public WebElement bloodGroupDropbox;

    @FindBy(id = "staff-adress")
    public WebElement adressTextbox;

    @FindBy(id = "staff-description")
    public WebElement descriptionTextbox;

    @FindBy(id = "staff-createdDate")
    public WebElement createdDateTextbox;

    @FindBy(id = "staff-country")
    public WebElement countryDropbox;

    @FindBy(id = "staff-cstate")
    public WebElement cstateDropbox;

    @FindBy(id = "save-entity")
    public WebElement savebutton;

    @FindBy(id = "staff-user")
    public WebElement userDropbox;




















}
