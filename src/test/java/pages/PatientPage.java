package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPage {

    public PatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='jh-card card']")
    public WebElement wholePatientObjects;

    @FindBy(xpath = "//*[text()='View']")
    public WebElement viewButton;



}
