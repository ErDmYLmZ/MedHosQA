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
    int row;
    @Then("verify that doctor can view all inpatient data")
    public void verify_that_doctor_can_view_all_inpatient_data() {

        for (int i = 0; i < doctorPage.listOfInpatientIDs.size(); i++) {
            System.out.println((i + 1) + ". id = " + doctorPage.listOfInpatientIDs.get(i).getText());
            if (doctorPage.listOfInpatientIDs.get(i).getText().equals("7202")) {
                //ID 7202 has all the fields populated. That's why i selected that id to assert
                row = i+1;
                break;}
        }

        String xpath = "//tr[" + (row) + "]/td";
        System.out.println("The row with the id 7202 (i use the 'row' for the xpath) = " + row);
        List<WebElement> elementList = Driver.getDriver().findElements(By.xpath(xpath));
        for (int i=0; i< elementList.size(); i++) {
            System.out.println(elementList.get(i).getText());
            Assert.assertFalse(elementList.get(i).getText().isEmpty());
        }
        System.out.println("size of the elements' list of the row is " + elementList.size());
        System.out.println("====================== The followings are from Test Case 2 to 7 ===============");
    }

    int editedRow;
    String id;
    @Given("user clicks edit button on inpatients page")
    public void user_clicks_edit_button_on_inpatients_page() throws InterruptedException {

        for (int i=0;  i<doctorPage.statusOfInpatients.size(); i++) {
            if(doctorPage.statusOfInpatients.get(i).getText().equals("STAYING")) {
                id = doctorPage.listOfInpatientIDs.get(i).getText();
                ReusableMethods.waitFor(2);
                doctorPage.editOfInpatients.get(i).click();
                editedRow =i+1;
                break;
            }
        }
        System.out.println();
        System.out.println("Edited row with 'STAYING' as status is " + editedRow);
        System.out.println("In the previous steps, we verified the data in the row = " + row); // 0 veriyor!!!
        System.out.println("In this step of clicking edit button, the row is ==> " + row +"\n"); // 0 veriyor!!!
    }

    Faker faker = new Faker();
    Date startDate = faker.date().past(20, TimeUnit.DAYS);
    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    @Given("user updates start date")
    public void user_updates_start_date() {
        String formattedStartDate = OurMethods.formatDateToSendKeys(startDate);
        System.out.println("formatted start date: " + formattedStartDate);//31.12.2021 05:09
        System.out.println("start date field Attribute is ==>>>" + doctorPage.startDateInpatient.getAttribute("Value"));
        doctorPage.startDateInpatient.sendKeys(formattedStartDate);
        System.out.println("edited row in validate_that_the_data_is_updated = " + editedRow); // 1 veriyor, dogru!!!
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
    String updatedStartDate;
    @Then("validate that start date is updated")
    public void validate_that_start_date_is_updated() {

        String reformattedStartDate = OurMethods.reformatForTestCase(startDate);
        System.out.println("reformatted start date = " + reformattedStartDate);// 31/12/21 21:51

        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals(id)) {
                updatedStartDate = doctorPage.startDateListInpatients.get(i).getText();
            }
        }
        System.out.println("exp start date "+reformattedStartDate+"---" + "updated start date "+updatedStartDate);
        Assert.assertNotEquals(reformattedStartDate, updatedStartDate);

    }
    @Given("user clicks edit button on inpatients page after update")
    public void user_clicks_edit_button_on_inpatients_page_after_update () {

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);

        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals("7201")) {
                id = doctorPage.listOfInpatientIDs.get(i).getText();
                ReusableMethods.waitFor(2);
                System.out.println(doctorPage.listOfInpatientIDs.get(i).getText());
                doctorPage.editOfInpatients.get(i).click();
                break;
            }
        }


    }

    Date createdDate = faker.date().past(20, TimeUnit.DAYS);
    Date endDate = faker.date().future(20, TimeUnit.DAYS);
    @Given("user updates end date")
    public void user_updates_end_date() {
//        String formattedEndDate = OurMethods.formatDateToSendKeys(endDate);
//        System.out.println("formatted end date:" + formattedEndDate);
        ReusableMethods.scrollToElement(doctorPage.endDateInpatient);
        ReusableMethods.waitFor(1);

//        doctorPage.endDateInpatient.sendKeys(formattedEndDate);
        doctorPage.endDateInpatient.sendKeys("31010020221652");// time is not sent. Thats why I used hard code for date
        System.out.println("end date field: " + doctorPage.endDateInpatient.getAttribute("Value"));

    }


    @Given("user views success message for end date update")
    public void user_views_success_message_for_end_date_update () {
        ReusableMethods.waitForVisibility(doctorPage.toastifySuccessMessage, 2);
        System.out.println(doctorPage.toastifySuccessMessage.getText());
        Assert.assertTrue(doctorPage.toastifySuccessMessage.getText().contains("The In Patient is updated with identifier"));
        ReusableMethods.waitFor(5);
    }
    String updatedEndDate;
    @Given("validate that end date is updated")
    public void validate_that_end_date_is_updated() {
        String reformattedEndDate = OurMethods.reformatForTestCase(endDate);
        System.out.println("reformatted end date = " + reformattedEndDate);//31/12/21 21:51
        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals(id)) {
                updatedEndDate = doctorPage.endDateListInpatients.get(i).getText();
            }
        }
//        System.out.println("reformattedEndDate "+reformattedEndDate+"---" + "updatedEndDate  "+updatedEndDate);
//        Assert.assertNotEquals(reformattedEndDate, updatedEndDate);
        Assert.assertNotEquals("31/01/22 16:52", updatedEndDate);
    }

    String description = faker.lorem().characters(2,10);
    @Given("user updates Description")
    public void user_updates_description() {
        doctorPage.descriptionInpatient.clear();
        doctorPage.descriptionInpatient.sendKeys(description);
        System.out.println("\n"+"sent description is " +description);
    }
    String updatedDescription;
    @Given("validate that Description is updated")
    public void validate_that_description_is_updated() {
        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals(id)) {
                updatedDescription = doctorPage.descriptionListInpatients.get(i).getText();
            }
        }
        System.out.println("description "+description+"---" + "updatedDescription "+updatedDescription);
        Assert.assertEquals(description, updatedDescription);
    }
    @Given("user updates Created Date")
    public void user_updates_created_date() {
        String formattedCreateDate = OurMethods.formatDateToSendKeys(createdDate);
        doctorPage.createdDateInpatient.sendKeys(formattedCreateDate);
    }

    String updatedCreatedDate;
    @Given("validate that Created Date is NOT updated")
    public void validate_that_created_date_is_not_updated() {

        String reformattedCreateDate = OurMethods.reformatForTestCase(createdDate);
        System.out.println("edited row at Create Date stepdefs is ==> " + editedRow);

        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals(id)) {
                updatedCreatedDate = doctorPage.createdDateListInpatients.get(i).getText();
            }
        }
        System.out.println("reformattedCreateDate "+reformattedCreateDate+"---" + "updatedCreatedDate "+updatedCreatedDate);
        Assert.assertNotEquals(reformattedCreateDate, updatedCreatedDate);
    }

    String textOfSentRoom;
    @Given("user updates ROOM")
    public void user_updates_room() {

        Select select = new Select(doctorPage.roomInpatients);
        select.selectByValue("1453");
        textOfSentRoom = "3";

    }
    String roomUpdated;
    @Given("validate that ROOM is updated")
    public void validate_that_room_is_updated() {

        for (int i=0; i<doctorPage.listOfInpatientIDs.size();i++) {
            if(doctorPage.listOfInpatientIDs.get(i).getText().equals(id)) {
                roomUpdated = doctorPage.roomListInpatients.get(i).getText();
            }
        }

        System.out.println("textOfSentRoom "+textOfSentRoom+"---" + "roomUpdated "+roomUpdated);
        Assert.assertEquals(textOfSentRoom, roomUpdated);

    }







}
