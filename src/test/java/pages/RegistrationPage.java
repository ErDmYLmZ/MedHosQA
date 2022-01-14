package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {



    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(name = "firstName")
    public WebElement firstnameTextbox;

    @FindBy(name = "lastName")
    public WebElement lastnameTextbox;

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(name = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement strengthBar;

    @FindBy(name = "secondPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration saved']")
    public WebElement successMessageToastContainer;

    @FindBy(xpath ="//*[text()='Your SSN is invalid']")
    public WebElement invalidFeedbackForSSN;

    @FindBy(xpath ="//*[text()='Your FirstName is required.']")
    public WebElement invalidFeedbackForFirstName;

    @FindBy(xpath ="//*[text()='Your LastName is required.']")
    public WebElement invalidFeedbackForLastName;

    @FindBy(xpath ="//*[text()='This SSN has been registered for another user!']")
    public WebElement failedMessageToastContainer;


    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement userNameRequiredText;


    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement emailRequiredText;












    //?? yeni olusturdum
    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerDropDownMenu;
}
