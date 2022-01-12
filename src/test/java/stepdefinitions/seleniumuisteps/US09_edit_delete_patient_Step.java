package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.PatientPage;
import pages.US09_StaffPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US09_edit_delete_patient_Step {

    US09_StaffPage staffPage = new US09_StaffPage();
    LoginPage loginPage = new LoginPage();
    CommonPageElements cp = new CommonPageElements();
    Faker faker =  new Faker();
    PatientPage patientPage = new PatientPage();





    @Given("user sign in as a staff")
    public void user_sign_in_as_a_staff() {
        Driver.waitAndClick(staffPage.signInButton);
        staffPage.username.sendKeys("max");
        staffPage.password.sendKeys("Ab12345.");
        Driver.waitAndClick(staffPage.signIn);

    }
    @When("user navigates to patients under MY PAGES dropdown")
    public void user_navigates_to_patients_under_my_pages_dropdown() {
        Driver.waitAndClick(staffPage.myPages);
        Driver.waitAndClick(staffPage.searchPatient);

    }
    @Then("verify the patient page")
    public void verify_the_patient_page() {
        Assert.assertTrue(staffPage.verifyPatientsInformation.getText().contains("Patients"));


    }
    @And("user selects a patient and clicks to view button")
    public void userSelectsAPatientAndClicksToViewButton() {
    patientPage.viewButton.click();
    }

    @Then("user verify all the necessary field is displayed")
    public void userVerifyAllTheNecessaryFieldIsDisplayed() {
    }
    //TC002

    @Given("user navigates to search patients under my pages dropdown")
    public void user_navigates_to_search_patients_under_my_pages_dropdown() {
        Driver.waitAndClick(staffPage.myPages);
        Driver.waitAndClick(staffPage.searchPatient);
    }
    @Given("enter a valid ssn number to patient ssn box")
    public void enter_a_valid_ssn_number_to_patient_ssn_box() {
        staffPage.ssnBox.clear();
        ReusableMethods.waitForPageToLoad(2);
        staffPage.ssnBox.sendKeys("123-77-5679");



    }


    @And("verify if user can see all registrant info")
    public void verify_if_user_can_see_all_registrant_info() {
        Driver.waitAndClick(patientPage.viewButton);
        List<WebElement> patientsDetailObject = Driver.getDriver().findElements(By.xpath("//div[@class='jh-card card']"));
        List<String> actualPageData = new ArrayList<>();
        actualPageData.add("SSN, First Name, Last Name, Birth Date, Phone, Email, Gender, Blood Group, Address, Description, Create Date, User, Country, State/City");

        Assert.assertTrue(patientsDetailObject.toString().contains(actualPageData.toString()));
        System.out.println(actualPageData.get(1));

    }
    @Then("user selects a patient and clicks to edit button")
    public void user_selects_a_patient_and_clicks_to_edit_button() {
        Driver.waitAndClick(staffPage.edit);

    }





    @Given("user verifies display patient all information")
    public void userDisplayPatientAllInformation() {
        Assert.assertTrue(staffPage.display.getText().contains("Create or edit a Patients"));
    }


    @When("user clicks to firstname box the system should allow to update the firstname")
    public void user_clicks_to_firstname_box_the_system_should_allow_to_update_the_firstname() {
        staffPage.firstName.clear();
        String firstName = faker.name().firstName().toString();
        System.out.println(firstName);
        staffPage.firstName.sendKeys(firstName);

    }
    @When("user clicks to lastname box the system should allow to update the lastname")
    public void user_clicks_to_lastname_box_the_system_should_allow_to_update_the_lastname() {
        staffPage.lastName.clear();
        String lastName = faker.name().lastName().toString();
        System.out.println(lastName);
        staffPage.lastName.sendKeys(lastName);

    }

    //??
    @When("user clicks to birthdate box the system should allow to update the birtdate")
    public void user_clicks_to_birthdate_box_the_system_should_allow_to_update_the_birtdate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyyy-MM-dd,hh:mmaa");

           String formattedBirthDate = sdf.format(faker.date().birthday(5,85));
            staffPage.birtDate.sendKeys( formattedBirthDate);


    }
    @When("user clicks to email box the system should allow to update the email")
    public void user_clicks_to_email_box_the_system_should_allow_to_update_the_email() {
        staffPage.email.clear();
        String email = faker.internet().emailAddress().toString();
        System.out.println(email);
        staffPage.email.sendKeys(email);

    }
    @When("user clicks to phone box the system should allow to update the phone")
    public void user_clicks_to_phone_box_the_system_should_allow_to_update_the_phone() {
       staffPage.phoneNumber.clear();
//        String phoneNumber = faker.number().randomDigit();
//        System.out.println(phoneNumber);
//        staffPage.phoneNumber.sendKeys(phoneNumber);

        staffPage.phoneNumber.sendKeys("4165667780");

    }
    @When("user clicks to gender dropdown the system should allow to update the gender")
    public void user_clicks_to_gender_dropdown_the_system_should_allow_to_update_the_gender() {

        Select select = new Select(staffPage.gender);
        ReusableMethods.selectRandomTextFromDropdown(select);


    }
    @When("user clicks to blood group dropdown the system should allow to update the blood group")
    public void user_clicks_to_blood_group_dropdown_the_system_should_allow_to_update_the_blood_group() {
        Select select2 = new Select(staffPage.bloodGroup);
        ReusableMethods.selectRandomTextFromDropdown(select2);

    }
    @When("user clicks to address box the system should allow to update the address")
    public void user_clicks_to_address_box_the_system_should_allow_to_update_the_address() {
        staffPage.address.clear();
        String address = faker.address().fullAddress().toString();
        System.out.println(address);
        staffPage.address.sendKeys(address);
    }
    @When("user clicks to description box the system should allow to update the description")
    public void user_clicks_to_description_box_the_system_should_allow_to_update_the_description() {
        staffPage.description.clear();
        staffPage.description.sendKeys("asthma");


    }
    @When("user clicks to user dropdown the system should allow to update the user")
    public void user_clicks_to_user_dropdown_the_system_should_allow_to_update_the_user() {
//        staffPage.user.clear();
        Select select4 = new Select(staffPage.user);
        ReusableMethods.selectRandomTextFromDropdown(select4);

    }
    @When("user clicks to country dropdown the system should allow to update the country")
    public void user_clicks_to_country_dropdown_the_system_should_allow_to_update_the_country() {
       // staffPage.country.clear();
        Select select5 = new Select(staffPage.country);
        select5.selectByIndex(1);
        ReusableMethods.selectRandomTextFromDropdown(select5);
    }

    @When("user clicks to state and city dropdown the system should allow to update the state and city")
    public void userClicksToStateAndCityDropdownTheSystemShouldAllowToUpdateTheStateAndCity() {
       Driver.waitForClickablility(staffPage.stateCity,2);
        Select select6 = new Select(staffPage.stateCity);
        ReusableMethods.selectRandomTextFromDropdown(select6);
    }

    @When("user click on save button")
    public void user_click_on_save_button() {

        Driver.waitAndClick(staffPage.save);

    }
    @Then("verify successfully editing patient information")
    public void verify_successfully_editing_patient_information() {
        ReusableMethods.waitForVisibility(staffPage.verifyPatient,3);
       Assert.assertTrue(staffPage.verifyPatient.getText().contains("Patients"));


    }






    @Then("verify there is no delete button")
    public void verifyThereIsNoDeleteButton() {
        List<WebElement> allPageObj = Driver.getDriver().findElements(By.xpath("//div[@class='jh-card card']"));
        System.out.println(ReusableMethods.getElementsText(allPageObj));
        Assert.assertFalse(allPageObj.toString().contains("Delete"));
        Driver.closeDriver();
    }




        @Given("admin navigates to patient page under the Items&Titles dropdown")
        public void admin_navigates_to_patient_page_under_the_items_titles_dropdown() {
          Driver.waitAndClick(cp.itemsAndTitles);
          Driver.waitAndClick(staffPage.patientDropdownAdmin);
        }
        @Then("verify there is no search box")
        public void verify_there_is_no_search_box() {
            List<WebElement> allPageObj = Driver.getDriver().findElements(By.xpath("//div[@class='jh-card card']"));
            System.out.println(ReusableMethods.getElementsText(allPageObj));
            Assert.assertFalse(allPageObj.toString().contains("Patients SSN:"));

        }



    @Given("user navigates to patients page under the Items&Titles dropdown")
    public void user_navigates_to_patients_page_under_the_items_titles_dropdown() {
        Driver.waitAndClick(cp.itemsAndTitles);
        Driver.waitAndClick(staffPage.patientDropdownAdmin);

    }
    @When("user selects the patient to delete and clicks on Delete button")
    public void user_selects_the_patient_to_delete_and_clicks_on_delete_button() {
        staffPage.deleteButton.click();
        ReusableMethods.waitFor(3);

    }


    @Then("verify user successfully deleted")
    public void verify_user_successfully_deleted() {
        ReusableMethods.waitFor(2);
       Assert.assertTrue(staffPage.verifyDelete.getText().contains("Confirm delete operation"));
       ReusableMethods.waitFor(2);
    }



}
