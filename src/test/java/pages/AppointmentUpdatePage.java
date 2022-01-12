package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentUpdatePage {

    public AppointmentUpdatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Show Test Results']")
    public WebElement showTestResults;
    @FindBy(xpath = "//*[text()='Request Inpatient']")
    public WebElement requestInpatient;
    @FindBy(xpath = "//*[text()='A new in Patient is created']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[text()='InPatient request already done for this appointment']")
    public WebElement errorMessage;
}
