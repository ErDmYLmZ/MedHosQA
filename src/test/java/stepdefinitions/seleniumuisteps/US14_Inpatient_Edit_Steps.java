package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DoctorPage;
import pojos.RowPojo;
import utilities.Driver;
import utilities.OurMethods;
import utilities.ReusableMethods;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US14_Inpatient_Edit_Steps {


    DoctorPage doctorPage = new DoctorPage();
    @Given("user navigates to My Inpatients page")
    public void user_navigates_to_my_inpatients_page() {
        Driver.waitAndClick(doctorPage.myPagesDropdown);
        Driver.waitAndClick(doctorPage.myInpatientsInDropdown);
    }
    int rowOfID_4903;
    @Then("verify that doctor can view all inpatient data")
    public void verify_that_doctor_can_view_all_inpatient_data() {
//        doctorPage.toDateInpatients.sendKeys("0901002022");
//        ReusableMethods.waitFor(2);
//        doctorPage.fromDateInpatients.sendKeys("28.12.2021");
//        ReusableMethods.waitFor(2);

        for (int i = 0; i < doctorPage.listOfInpatientIDs.size(); i++) {
//            System.out.println((i + 1) + ". id = " + doctorPage.listOfInpatientIDs.get(i).getText());
            if (doctorPage.listOfInpatientIDs.get(i).getText().equals("5451")) {
                rowOfID_4903 = i+1;
                break;}

        }

        String xpath = "//tr[" + (rowOfID_4903) + "]/td";
        System.out.println("xpath of the row with the id 5451 (degistirdim) = " + rowOfID_4903);
        List<WebElement> elementsOfRowWithID_4903 = Driver.getDriver().findElements(By.xpath(xpath));
        for (int i=0; i< elementsOfRowWithID_4903.size(); i++) {
//            System.out.println(elementsOfRowWithID_4903.get(i).getText());
            Assert.assertFalse(elementsOfRowWithID_4903.get(i).getText().isEmpty());
        }

    }
    // edit and update info start date, end date, desc, created date(NOT),
//    int editedRow1;
    RowPojo rowPojo = new RowPojo();
    int rowPojo1;
    @Given("user clicks edit button on inpatients page")
    public void user_clicks_edit_button_on_inpatients_page() throws InterruptedException {
//        doctorPage.toDateInpatients.sendKeys("0901002022");
//        ReusableMethods.waitFor(2);
//        doctorPage.fromDateInpatients.sendKeys("28.12.2021");
//        ReusableMethods.waitFor(2);

        for (int i=0;  i<doctorPage.statusOfInpatients.size(); i++) {
            if(doctorPage.statusOfInpatients.get(i).getText().equals("STAYING")) {

                ReusableMethods.waitFor(2);
                doctorPage.editOfInpatients.get(i).click();
                int editedRow1 =i+1;
                rowPojo1 = rowPojo.setEditedRowFromPojo(editedRow1);
                break;

            }

        }
       //rowPojo1 = rowPojo.setEditedRowFromPojo(editedRow1);
        System.out.println("edited row from pojo " + rowPojo1);
//        System.out.println("Edited row with 'STAYING' as status is " + editedRow1);
    }

    Faker faker = new Faker();
    Date startDate = faker.date().past(20, TimeUnit.DAYS);
    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    @Given("user updates start date")
    public void user_updates_start_date() {
    String formattedStartDate = OurMethods.formatDateToSendKeys(startDate);
        System.out.println("formatted start date: " + formattedStartDate);
        doctorPage.startDateInpatient.sendKeys(formattedStartDate);
    }
    @Given("user clicks on save button on edit inpatient page")
    public void user_clicks_on_save_button_on_edit_inpatient_page() {
        ReusableMethods.scrollIntoViewJS(doctorPage.saveInpatient);
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForClickablility(doctorPage.saveInpatient, 2);
        doctorPage.saveInpatient.click();
    }
    @Then("user views success message")
    public void user_views_success_message() {
        ReusableMethods.waitForVisibility(doctorPage.toastifySuccessMessage, 2);
        System.out.println(doctorPage.toastifySuccessMessage.getText());
        ReusableMethods.waitFor(2);
        Assert.assertTrue(doctorPage.toastifySuccessMessage.getText().contains("The In Patient is updated with identifier"));
    }
    @Then("validate that the data is updated")
    public void validate_that_the_data_is_updated() {

//        doctorPage.toDateInpatients.sendKeys("0901002022");
//        ReusableMethods.waitFor(2);
//        doctorPage.fromDateInpatients.sendKeys("28.12.2021");
//        ReusableMethods.waitFor(2);

//        System.out.println("edited row in validate_that_the_data_is_updated = " + editedRow1);
        System.out.println("edited row from pojo is " + rowPojo.getEditedRowFromPojo());
        String textOfEditedStartDate = OurMethods.getElementTextByRowAndColumn(1,2);
        System.out.println(textOfEditedStartDate);

        String reformattedStartDate = OurMethods.reformatForTestCase(startDate);
        System.out.println("reformatted start date = " + reformattedStartDate);//31/12/21 21:51
        Assert.assertNotEquals(reformattedStartDate, textOfEditedStartDate); // TestCase fails - BUG
    }
    @Given("user clicks edit button on inpatients page after update")
    public void user_clicks_edit_button_on_inpatients_page_after_update () {
//        System.out.println("FIRST line edited row in user_clicks_edit_button_on_inpatients_page_after_update " + editedRow1);
        System.out.println("edited row from pojo is " + rowPojo.getEditedRowFromPojo());
        //WebElement editButtonWithStaying = OurMethods.getElementByRowAndColumn(editedRow1, 10);

//    ReusableMethods.clickWithJS(doctorPage.editButtonOfID_4901); calismadi !!!
        // scroll olsa yukarida kaliyor, scroll olmassa asagida kaliyor. Arada kalan button!!!
        // Actions kullanarak down arrow ile scroll yapip tikladim!
//        Actions actions = new Actions(Driver.getDriver());
//        actions.sendKeys(Keys.PAGE_UP).perform();
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
//        actions.sendKeys(Keys.ARROW_DOWN).perform();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();

//        System.out.println("edited row in user_clicks_edit_button_on_inpatients_page_after_update " + editedRow1);
//        ReusableMethods.scrollIntoViewJS(OurMethods.getElementByRowAndColumn(1,10));
        ReusableMethods.waitFor(1);
        Driver.waitAndClick(OurMethods.getElementByRowAndColumn(1,10));
    }

    Date createdDate = faker.date().past(20, TimeUnit.DAYS);
    Date endDate = faker.date().future(20, TimeUnit.DAYS);
    @Given("user updates end date")
    public void user_updates_end_date() {
//        String formattedEndDate = OurMethods.formatDateToSendKeys(endDate);
//        System.out.println("formatted end date:" + formattedEndDate);

        ReusableMethods.waitFor(2);
        ReusableMethods.scrollToElement(doctorPage.endDateInpatient);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
//        doctorPage.endDateInpatient.sendKeys(formattedEndDate);
        doctorPage.endDateInpatient.sendKeys("23010020220657");
        // end date saatini almadigi icin boyle yaptik
    }


    @Given("user views success message for end date update")
    public void user_views_success_message_for_end_date_update () {
        ReusableMethods.waitForVisibility(doctorPage.toastifySuccessMessage, 2);
        System.out.println(doctorPage.toastifySuccessMessage.getText());
        Assert.assertTrue(doctorPage.toastifySuccessMessage.getText().contains("The In Patient is updated with identifier"));
        //ReusableMethods.waitFor(5);
    }

    @Given("validate that end date is updated")
    public void validate_that_end_date_is_updated() {
        WebElement elementEditedEndDate = OurMethods.getElementByRowAndColumn(1,3);
        System.out.println("end date text is ==> " + elementEditedEndDate.getText());
//
//        String reformattedEndDate = OurMethods.reformatForTestCase(endDate);
//        System.out.println("reformatted end date = " + reformattedEndDate);//31/12/21 21:51
        Assert.assertNotEquals("31/12/21 21:51", elementEditedEndDate.getText()); // TestCase fails - BUG


    }

    String description = faker.lorem().characters(2,30);
    @Given("user updates Description")
    public void user_updates_description() {
    doctorPage.descriptionInpatient.clear();
    doctorPage.descriptionInpatient.sendKeys(description);
        System.out.println("sent description is " +description);
    }
    @Given("validate that Description is updated")
    public void validate_that_description_is_updated() {
        String textOfEditedDescription = OurMethods.getElementTextByRowAndColumn(1,5);
        System.out.println("description seen after update is  " + textOfEditedDescription);
        Assert.assertEquals(description, textOfEditedDescription);
    }
    @Given("user updates Created Date")
    public void user_updates_created_date() {
        String formattedCreateDate = OurMethods.formatDateToSendKeys(createdDate);
        doctorPage.createdDateInpatient.sendKeys(formattedCreateDate);
    }
    @Given("validate that Created Date is NOT updated")
    public void validate_that_created_date_is_not_updated() {
        String textOfEditedCreateDate = OurMethods.getElementTextByRowAndColumn(1, 6);
        System.out.println(textOfEditedCreateDate);

        String reformattedCreateDate = OurMethods.reformatForTestCase(createdDate);
        Assert.assertNotEquals(reformattedCreateDate,textOfEditedCreateDate); // it should be expected!!!

//        System.out.println("edited row at the last line is ==> " + editedRow1);
        System.out.println("edited row from pojo is " + rowPojo.getEditedRowFromPojo());
    }

    String textOfSentRoom;
    @Given("user updates ROOM")
    public void user_updates_room() {

    Select select = new Select(doctorPage.roomInpatients);
    select.selectByValue("3752");
    textOfSentRoom = "234:SUITE FULL-UNAVAILABLE";

    }

    @Given("validate that ROOM is updated")
    public void validate_that_room_is_updated() {

        String textOfEditedRoom = OurMethods.getElementTextByRowAndColumn(1,7);
        System.out.println("description seen after update is  " + textOfEditedRoom);
        System.out.println("sent room from previous step is " + textOfSentRoom);
        Assert.assertEquals(textOfSentRoom, textOfEditedRoom);
    }







}
