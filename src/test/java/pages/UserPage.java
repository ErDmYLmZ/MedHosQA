package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserPage {
    public UserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //User page elements - Bahar

    @FindBy(xpath = "//*[text()='Users']")
    public WebElement usersPageText;

    //I took the exact user with id:3313 - Bahar
    @FindBy(xpath = "//*[text()='3313']")
    public WebElement user3313;

    @FindBy(xpath = "(//*[text()='View'])[15]")
    public WebElement viewButton3313;

    @FindBy(xpath = "(//*[text()='Edit'])[15]")
    public WebElement editButton3313;

    @FindBy(xpath = "(//*[text()='Delete'])[15]")
    public WebElement deleteButton3313;

    //User 3313 view page elements - Bahar
    @FindBy(xpath = "//*[text()='First name']")
    public WebElement userFirstName;

    @FindBy(xpath = "//*[text()='Last name']")
    public WebElement userLastName;

    @FindBy(xpath = "//*[text()='Email']")
    public WebElement userEmail;

    @FindBy(xpath = "//*[text()='Language']")
    public WebElement userLanguage;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//*[text()='Confirm delete operation']")
    public WebElement deleteConfirmationText;

    //The 15th delete button - Bahar
    @FindBy(xpath = "(//*[text()='Delete'])[15]")
    public WebElement deleteButton15;

    @FindBy(xpath = "//div[contains(text(), 'A user is deleted')]")
    public WebElement successMessageForDeletion;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;

    //Create or Edit a User Page Elements - Bahar
    @FindBy(xpath = "//*[text()='ROLE_PHYSICIAN']")
    public WebElement rolePhysician;

    @FindBy(xpath = "//*[text()='ROLE_STAFF']")
    public WebElement roleStaff;

    @FindBy(id = "activated")
    public WebElement activatedCheckbox;

    @FindBy(id = "firstName")
    public WebElement firstNameBox;

    @FindBy(id = "lastName")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

}
