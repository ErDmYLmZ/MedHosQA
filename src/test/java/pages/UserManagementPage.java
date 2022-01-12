package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class UserManagementPage {
    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindAll({@FindBy(xpath = "//tbody/tr/td[2]")})
    public List<WebElement> userNames;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[3]")})
    public List<WebElement> userSSNs;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[4]")})
    public List<WebElement> userEmails;
    @FindAll({@FindBy(xpath = "//tbody/tr/td[5]")})
    public List<WebElement> userActivations;
    @FindAll({@FindBy(xpath = "//*[text()='Edit']")})
    public List<WebElement> editButtons;
}