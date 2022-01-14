package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US09_StaffPage {

    public US09_StaffPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login-item")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement signIn;



    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPages;

    @FindBy(xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement searchPatient;


    @FindBy(xpath = "//*[text()='Patients SSN:']")
    public WebElement patientSsn;

    @FindBy(xpath = "//*[text()='Patients']")
    public WebElement verifyPatientsInformation;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement edit;



    @FindBy(xpath = "//*[text()='Create or edit a Patient']")
    public WebElement display;

    @FindBy(id = "patient-id")
    public WebElement id;

    @FindBy(id = "patient-firstName")
    public WebElement firstName;

    @FindBy(id = "patient-lastName")
    public WebElement lastName;

    @FindBy(id = "patient-birthDate")
    public WebElement birtDate;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "patient-phone")
    public WebElement phoneNumber;

    @FindBy(id = "patient-gender")
    public WebElement gender;

    @FindBy(id = "patient-bloodGroup")
    public WebElement bloodGroup;

    @FindBy(id = "patient-adress")
    public WebElement address;

    @FindBy(id = "patient-description")
    public WebElement description;

    @FindBy(id = "patient-user")
    public WebElement user;

    @FindBy(id = "patient-country")
    public WebElement country;

    @FindBy(id = "patient-cstate")
    public WebElement stateCity;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement save;

    @FindBy(xpath = "//*[text()='Patient']")
    public WebElement verifyPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//*[text()='View']")
    public WebElement verifyAllRegistrantInfo;

    @FindBy(xpath = "//*[text()='5551']")
    public WebElement annaId;



    //Admin

    @FindBy(xpath = "//*[text()='Patient']")
    public WebElement patientDropdownAdmin;


    @FindBy(xpath = "//div[@class='view-routes']")
    public WebElement patientsElementList;

    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Confirm delete operation']")
    public WebElement verifyDelete;



    @FindBy(xpath = "//*[text()='SSN']")
    public WebElement patientSsnId;

}
