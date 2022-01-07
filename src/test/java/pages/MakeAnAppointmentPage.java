package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MakeAnAppointmentPage {

    public MakeAnAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement makeAnAppointmentButton;

    @FindBy(id = "firstName")
    public WebElement firstnameButton;

    @FindBy(id = "ssn")
    public WebElement SsnButton;

    @FindBy(id = "lastName")
    public WebElement lastnameButton;

    @FindBy(id = "email")
    public WebElement emailButton;

    @FindBy(id = "phone")
    public WebElement phoneButton;

   @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement sendAnAppointmentRequestButton;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement greenPart;

    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesPatientDropDownMenu;

    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentsDropDown;

    @FindBy(id = "appointment-heading")
    public WebElement appointmentsDisplayed;







}
