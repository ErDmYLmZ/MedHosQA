package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansPage {

    public PhysiciansPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Create a new Physician']")
    public WebElement createANewPhysician;

    @FindBy(xpath="//*[text()='View']")
    public WebElement viewButton;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deleteButton;

}