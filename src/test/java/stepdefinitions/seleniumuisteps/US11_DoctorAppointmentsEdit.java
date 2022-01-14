package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPageElements;
import pages.DrAppointmentsPage;
import utilities.Driver;

public class US11_DoctorAppointmentsEdit {
    CommonPageElements cp=new CommonPageElements();
    DrAppointmentsPage app=new DrAppointmentsPage();

    @Given("clicks the my pages button")
    public void clicks_the_my_pages_button() {
        cp.myPagesButton.click();
    }
    @Given("click my appointments button")
    public void click_my_appointments_button() {
        cp.myAppointmentsButton.click();
    }


    @And("click Edit button")
    public void clickEditButton() {
        Driver.waitAndClick(app.EditButton);
    }

    @Then("verify Edit page is opened")
    public void verifyEditPageIsOpened() {
        Assert.assertTrue(app.editPageText.isDisplayed());
        System.out.println(app.editPageText.getText());
    }

    @Then("verify doctor should be able to see patient's id,start and end date,Status,Physician and patient")
    public void verifyDoctorShouldBeAbleToSeePatientSIdStartAndEndDateStatusPhysicianAndPatient() {

        String expectedId="7106";
        String actualId=app.appointmentId.getAttribute("value").trim();
        Assert.assertTrue(expectedId.equals(actualId));// validation with patient ID

        Assert.assertTrue(app.appointmentId.isDisplayed());
        Assert.assertTrue(app.startDate.isDisplayed());
        Assert.assertTrue(app.endDate.isDisplayed());
        Assert.assertTrue(app.status.isDisplayed());
        Assert.assertTrue(app.physicianId.isDisplayed());
        Assert.assertTrue(app.patientId.isDisplayed());

        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);
//       Driver.closeDriver();


    }

    @And("Type in fields Anamnesis {string} ,Treatment {string},Diagnosis {string}")
    public void typeInFieldsAnamnesisTreatmentDiagnosis(String arg0, String arg1, String arg2) {
        app.anamnesisText.clear();
        app.anamnesisText.sendKeys(arg0);
        app.treatmentText.clear();
        app.treatmentText.sendKeys(arg1);
        app.diagnosisText.clear();
        app.diagnosisText.sendKeys(arg2);
    }


    @Then("Verify doctor can type the fields {string},{string},{string}")
    public void verifyDoctorCanTypeTheFields(String arg0, String arg1, String arg2) {
        Assert.assertTrue(app.anamnesisText.getText().equals(arg0));
        //  System.out.println(app.anamnesisText.getText());
        Assert.assertTrue(app.treatmentText.getText().equals(arg1));
        Assert.assertTrue(app.diagnosisText.getText().equals(arg2));
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);

    }

    @And("Don't type in Anamnesis,Treatment,Diagnosis")
    public void donTTypeInAnamnesisTreatmentDiagnosis() {

        app.anamnesisText.clear();
        app.treatmentText.clear();
        app.diagnosisText.clear();


    }


    @Then("Verify there should be an error message")
    public void verifyThereShouldBeAnErrorMessage() {
        Driver.waitAndClick(app.saveButton);
        String expectedErrorMsg="This field is required.";
        Assert.assertTrue(app.errorMessage1.getText().equals(expectedErrorMsg));
        System.out.println(expectedErrorMsg);
        app.errorMessage1.isDisplayed();
        app.errorMessage2.isDisplayed();
        app.errorMessage3.isDisplayed();
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);

    }

    @Given("Don't Type in prescription and description fields")
    public void donTTypeInPrescriptionAndDescriptionFields() {
        app.prescriptionText.clear();
        app.descriptionText.clear();

    }

    @And("click save button")
    public void clickSaveButton() {
        Driver.waitAndClick(app.saveButton);
    }

    @Then("Verify appointment is saved")
    public void verifyAppointmentIsSaved() {
        Driver.waitForVisibility(app.alertSave,3);

        String alertMsg=app.alertSave.getText();
        System.out.println(alertMsg);

        Assert.assertTrue(alertMsg.contains("updated"));
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);

    }

    @Given("Click the status dropdown")
    public void clickTheStatusDropdown() {
//        app.status.click();
    }

    @And("select status type")
    public void selectStatusType() {
        Driver.selectAnItemFromDropdown(app.status,"COMPLETED");
    }

    @Then("Verify status type is selected.")
    public void verifyStatusTypeIsSelected() {

        String statusText= app.completedText.getText();
        System.out.println(statusText);
        Assert.assertTrue(statusText.contains("COMPLETED"));
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);

    }

    @And("select status type {string}")
    public void selectStatusType(String arg0) {
        Driver.selectAnItemFromDropdown(app.status,"UNAPPROVED");

    }

    @Then("verify status type  shouldn't be selected.")
    public void verifyStatusTypeShouldnTBeSelected() {
        Select select=new Select(app.status);
        String txt=select.getOptions().get(0).getAttribute("disabled");
        System.out.println(txt);
        Assert.assertTrue(txt.equals("true"));
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signOut);
    }

    @Given("user navigates to lending page {string}")
    public void userNavigatesToLendingPage(String url) {
        Driver.navigateToUrl(url);
    }
}
