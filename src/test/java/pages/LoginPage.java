package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(name="rememberMe")
    public WebElement rememberMeCheckmark;

    @FindBy(xpath="(//span[text()='Sign in'])[3]")
    public WebElement loginButton;

    @FindBy(xpath="//*[text()='Did you forget your password?']")
    public WebElement updatePassword;
    @FindBy(xpath="//*[text()='Register a new account']")
    public WebElement proceedToRegistration;
    @FindBy(xpath="//*[text()='Registration']")
    public WebElement registerVerify;

    @FindBy (className = "Toastify__toast-body")

    public WebElement failedLogin;

    @FindBy (xpath = "//*[@name='rememberMe']")
    public WebElement rememberMeCheckValue;
    @FindBy(xpath = "//*[@id='login-title']")
    public  WebElement loginTitle;

    @FindBy(xpath="//*[@id='login-title']/button")
    public WebElement cancelButton;



    //??yenisini olusturdum
    @FindBy(id = "login-item")
    public WebElement signInDropDown;

}
