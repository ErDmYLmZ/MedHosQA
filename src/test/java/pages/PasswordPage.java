package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PasswordPage {
    public PasswordPage(){PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement strengthBar;
}
