package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DrAppointmentsPage {
    public DrAppointmentsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement EditButton;

    @FindBy(xpath = "//span[text()='Create or Edit an Appointment']")
    public WebElement editPageText;

    @FindBy(name = "id")
    public WebElement appointmentId;

    @FindBy(name = "startDate")
    public WebElement startDate;

    @FindBy(name = "endDate")
    public WebElement endDate;

    @FindBy(name = "status")
    public WebElement status;

    @FindBy(name = "physician.id")
    public WebElement physicianId;

    @FindBy(name = "patient.id")
    public WebElement patientId;

    @FindBy(name = "anamnesis")
    public WebElement anamnesisText;

    @FindBy(name = "treatment")
    public WebElement treatmentText;

    @FindBy(name = "diagnosis")
    public WebElement diagnosisText;

    @FindBy(name = "prescription")
    public WebElement prescriptionText;

    @FindBy(id = "appointment-description")
    public WebElement descriptionText;

    @FindBy(id="save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement errorMessage1;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement errorMessage2;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    public WebElement errorMessage3;

@FindBy(xpath = "//div[@role='alert']")
    public WebElement alertSave;

@FindBy(xpath = "//option[@value='COMPLETED']")
    public WebElement completedText;
    @FindBy(xpath = "//*[text()='Appointments']")

    public WebElement appointmentTextVerify;


}
