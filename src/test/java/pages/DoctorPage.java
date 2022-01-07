package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoctorPage {

public DoctorPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

@FindBy (id = "entity-menu")
public WebElement myPagesDropdown;

    @FindBy(xpath = "//span[.='My Inpatients']")
    public WebElement myInpatientsInDropdown;

    // onemli: findElements icin asagidakini kullanabiliriz!!!
    @FindBy(xpath = "//tr[4]/td[10]") // hardcoded olmamasi icin bunu kullanmadim
    public WebElement editButtonOfID_4901; // I get the exact id 4901

    @FindBy(xpath = "//tr[4]/td[10]") // hardcoded olmamasi icin bunu kullanmadim
    public List<WebElement> stayingRowList; // I get the exact id 4901


    @FindAll({@FindBy(xpath = "//tr/td[4]")}) // driver.findElements(By.xpath="") gibi
    public List<WebElement> statusOfInpatients ; // settar hocadan- list olarak almak icin

    @FindAll({@FindBy(xpath = "//tr/td[10]")}) //
    public List<WebElement> editOfInpatients ; // settar hocadan

    @FindBy(id = "in-patient-startDate")
    public WebElement startDateInpatient;

    @FindBy(id = "in-patient-endDate")
    public WebElement endDateInpatient;

    @FindBy(id = "in-patient-description")
    public WebElement descriptionInpatient;

    @FindBy(id = "in-patient-createdDate")
    public WebElement createdDateInpatient;

    @FindBy(id = "in-patient-status")
    public WebElement statusInpatient;

    @FindBy(id = "in-patient-room")
    public WebElement roomInpatient;

    @FindBy(id = "save-entity")
    public WebElement saveInpatient;

    @FindBy(id = "cancel-save")
    public WebElement backInpatient;

    @FindBy(xpath = "//*[contains(text(), 'In Patient is updated')]")
    public WebElement toastifySuccessMessage;




    //Bahar's Doctor Page elements
    //@FindBy(xpath = "//*[text()='MY PAGES']") // I commented out this as it is already defined above(Bahar)
    //public WebElement myPagesDropdown;

    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[text()='My Patients']")
    public WebElement myPatients;

    @FindBy(xpath = "//*[text()='My Inpatients']")
    public WebElement myInpatients;

    //APPOINTMENTS PAGE ELEMENTS - Bahar
    @FindBy(xpath = "//*[text()='Appointments']")
    public WebElement appointmentsPageText;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[5]")
    public WebElement editButtonForNewPatient;

    //Create or edit an Appointment PAGE ELEMENT - Bahar
    @FindBy(xpath = "//*[text()='Create or edit a Appointment']")
    public WebElement createOrEditAnAppointmentPageText;

    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestATestButton;

    //TEST ITEMS PAGE ELEMENTS - Bahar
    @FindBy(xpath = "//*[text()='Test Items']")
    public WebElement testItemsPageText;

    @FindBy(id = "1401")
    public WebElement glucose;

    @FindBy(id = "1402")
    public WebElement urea;

    @FindBy(id = "1403")
    public WebElement creatinine;

    @FindBy(id = "1404")
    public WebElement sodium;

    @FindBy(id = "1405")
    public WebElement potassium;

    @FindBy(id = "1406")
    public WebElement totalProtein;

    @FindBy(id = "1407")
    public WebElement albumin;

    @FindBy(id = "1408")
    public WebElement hemoglobin;

    @FindBy(id = "4002")
    public WebElement mcv;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'A new Test is created')]")
    public WebElement successMessageForTestCreation;





}


