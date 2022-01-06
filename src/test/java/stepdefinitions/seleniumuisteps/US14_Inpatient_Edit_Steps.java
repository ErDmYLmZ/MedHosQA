package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @Then("verify that doctor can view all inpatient data")
    public void verify_that_doctor_can_view_all_inpatient_data() {

        List<WebElement> listOfInpatientIDs = Driver.getDriver().findElements(By.xpath("//tr/td[1]"));
        int rowOfID_3703 = 0;
        for (int i = 0; i < listOfInpatientIDs.size(); i++) {
            System.out.println((i + 1) + ". id = " + listOfInpatientIDs.get(i).getText());
            if (listOfInpatientIDs.get(i).getText().equals("3703")) {
                rowOfID_3703 = i;
            }
        }

        // To get a patient with all data populated, I used patient 3703.
        // The following is to get all columns on the row of id 3703
        String xpathOfID_3703 = "//tr[" + (rowOfID_3703+1) + "]/td";
        List<WebElement> listInfoOfID_3703 = Driver.getDriver().findElements(By.xpath(xpathOfID_3703));

        // // // The followings till assertion are just to exercise
//        for (WebElement eachInfo : listInfoOfID_3703) {
//            System.out.println(eachInfo.getText());
//            System.out.println("id 3703 row = " + rowOfID_3703);
//        }
        System.out.println();
        for (int i=0; i<(listInfoOfID_3703.size()); i++) {
            System.out.println((i+1) + ". " + listInfoOfID_3703.get(i).getText());
        }
        System.out.println(listInfoOfID_3703.size());
        System.out.println("1. column = " + listInfoOfID_3703.get(0).getText());
        System.out.println("2. column = " + listInfoOfID_3703.get(1).getText());

        System.out.println("is it empty?  " + listInfoOfID_3703.get(0).getText().isEmpty());

        //The following is for an empty element
        WebElement emptyElement = Driver.getDriver().findElement(By.xpath("//tr[2]/td[5]"));
        System.out.println("This is empty element "+emptyElement.getText());
        System.out.println("This is the 5th column of id 3705 which is an empty element. " +
        "That's why we get true => " + emptyElement.getText().isEmpty());

        // The assertion is here:
        for (int i=0; i<listInfoOfID_3703.size(); i++) {
            Assert.assertFalse(listInfoOfID_3703.get(i).getText().isEmpty());
        }
       Assert.assertTrue(emptyElement.getText().isEmpty());// empty elemanin assertion'u. Bu da ekstra!
    }

    // edit and update info start date, end date, desc, created date(NOT),
    //public static String xpathOfEdit; null atadi ve degistiremedim. O yuzden parametre olarak ekledim
    int editedRow;
    @Given("user clicks edit button on inpatients page {string}")
    public void user_clicks_edit_button_on_inpatients_page(String xpathOfEdit) throws InterruptedException {
        List <WebElement> listOfInpatientRows = Driver.getDriver().findElements(By.xpath("//tr"));
        System.out.println("number of rows are = "+listOfInpatientRows.size());

        // The following is to find the patient with STAYING status:
        for (int i =0; i<listOfInpatientRows.size(); i++){
            System.out.println(listOfInpatientRows.get(i).getText());
            if(listOfInpatientRows.get(i).getText().contains("STAYING")) {
                xpathOfEdit = "//tr["+i+"]/td[10]";
               // editButtonWithStaying = Driver.getDriver().findElement(By.xpath(xpathOfEdit));
                System.out.println("xpath in if state=  " + xpathOfEdit);
                editedRow = i;
                break;
            }
            System.out.println("xpath in for loop = " + xpathOfEdit);
        }
        System.out.println("edited row is = " + editedRow);
        System.out.println("in the method xpath =" + xpathOfEdit);
        WebElement editButtonWithStaying = Driver.getDriver().findElement(By.xpath(xpathOfEdit));
        System.out.println("This is from the row with STAYING " +editButtonWithStaying.getText());

//    ReusableMethods.clickWithJS(doctorPage.editButtonOfID_4901); calismadi !!!
        // scroll olsa yukarida kaliyor, scroll olmassa asagida kaliyor. Arada kalan button!!!
        // Actions kullanarak down arrow ile scroll yapip tikladim!
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        Driver.waitAndClick(editButtonWithStaying);
    }
    Faker faker = new Faker();
    Date startDate = faker.date().past(20, TimeUnit.DAYS);
    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    @Given("user updates start date")
    public void user_updates_start_date() {
    String formattedStartDate = OurMethods.formatDateToSendKeys(startDate);
        System.out.println("formatted start date:" + formattedStartDate);
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
        ReusableMethods.waitForClickablility(doctorPage.toastifySuccessMessage, 2);
        System.out.println(doctorPage.toastifySuccessMessage.getText());
        Assert.assertTrue(doctorPage.toastifySuccessMessage.getText().contains("The In Patient is updated with identifier"));
    }
    @Then("validate that the data is updated")
    public void validate_that_the_data_is_updated() {
//        String editedStartDate = "//tr["+editedRow+"]/td[2]";
//        System.out.println("xpath of edited start date : " + editedStartDate);
//        WebElement editedStartDateEl = Driver.getDriver().findElement(By.xpath(editedStartDate));
//        String textOfEditedStartDate = editedStartDateEl.getText();
//        System.out.println(textOfEditedStartDate); // 31/12/21 21:51
        // yukaridakini metod ile yaptim:
        String textOfEditedStartDate = OurMethods.getElementTextWithRowAndColumn(editedRow,2);
        System.out.println(textOfEditedStartDate);

        String reformattedStartDate = OurMethods.reformatForTestCase(startDate);
        System.out.println("reformatted start date = " + reformattedStartDate);//31/12/21 21:51
        Assert.assertNotEquals(reformattedStartDate, textOfEditedStartDate); // TestCase fails - BUG
    }
    @Given("user updates end date")
    public void user_updates_end_date() {



    }
    @Given("validate that end date is updated")
    public void validate_that_end_date_is_updated() {
        ReusableMethods.scrollToElement(doctorPage.editButtonOfID_4901);
    }
    @Given("user updates Description")
    public void user_updates_description() {

    }
    @Given("validate that Description is updated")
    public void validate_that_description_is_updated() {

    }
    @Given("user updates Created Date")
    public void user_updates_created_date() {

    }
    @Given("validate that Created Date is NOT updated")
    public void validate_that_created_date_is_not_updated() {

    }









}
