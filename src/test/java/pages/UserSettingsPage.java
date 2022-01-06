package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSettingsPage {

    public UserSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameTb;

    @FindBy(id = "lastName")
    public WebElement lastNameTb;

    @FindBy(id = "email")
    public WebElement emailTb;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@class='Toastify']")
    public WebElement alert;
}