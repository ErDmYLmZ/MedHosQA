package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.StaffPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;
import java.util.Random;

public class StaffStepDefs {

    CommonPageElements cp = new CommonPageElements();
    LoginPage login = new LoginPage();
    StaffPage staffPage = new StaffPage();
    Faker faker = new Faker();

    @Given("login with {string} account")
    public void login_with_account(String account) {
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(cp.signIn);
        switch(account){
            case "admin" :
                Driver.waitAndSendText(login.username, ConfigReader.getProperty("admin"));
                break;
            case "staff" :
                Driver.waitAndSendText(login.username, ConfigReader.getProperty("staff"));
                break;
        }
        Driver.sleep(1000);
        Driver.waitAndSendText(login.password, ConfigReader.getProperty("password"));
        Driver.waitAndClick(login.loginButton);

    }
    @Given("admin navigate page {string}")
    public void admin_navigate_page(String page) {

        Driver.waitAndClick(cp.itemsAndTitles);
        switch(page) {
            case "staff" :
                Driver.waitAndClick(cp.staff);
                break;

        }

    }
    @Given("admin click {string}")
    public void admin_click(String button) {
        switch(button) {
            case "Create a new Staff" :
                Driver.waitAndClick(staffPage.createANewStaff);
                break;
        }


    }
    @When("user enter valid existing ssn id {string}")
    public void user_enter_valid_existing_ssn_id(String ssnId) {
        Driver.waitAndSendText(staffPage.ssnTextbox, ssnId);

    }
    @When("check the checkbox of  {string}")
    public void check_the_checkbox_of(String checkbox) {
        switch(checkbox) {
            case "Use search" :
                Driver.waitAndClick(staffPage.useSearchCheckBox);
                break;
        }

    }
    @Then("the related staff will appear in the form")
    public void the_related_staff_will_appear_in_the_form() throws InterruptedException {

        Driver.waitAndClick(staffPage.searchUserbutton);
        Thread.sleep(3000);
        Assert.assertTrue(staffPage.firstNameTextbox.getAttribute("value").equals("Gok"));

    }

    @Then("admin will get toastify success message")
    public void admin_will_get_toastify_success_message() {
        Assert.assertTrue(staffPage.toastifSuccess.getText().equals("User found with search SSN"));
    }

    @Then("admin will get toastify failure message")
    public void admin_will_get_toastify_failure_message() throws InterruptedException {
        Driver.waitAndClick(staffPage.searchUserbutton);
        Thread.sleep(3000);
        Assert.assertTrue(staffPage.toastifSuccess.getText().equals("Not found"));
    }

    @Given("enter all fields")
    public void enter_all_fields() throws InterruptedException {
        Driver.waitAndSendText(staffPage.phoneTextbox, "0123456789", 2);
        Select gender = new Select(staffPage.genderDropbox);
        Random rn = new Random();
        int gNum = Math.abs(rn.nextInt(2));
        gender.selectByIndex(gNum);
        Select bloodGroup = new Select(staffPage.bloodGroupDropbox);
        int bNum = Math.abs(rn.nextInt(7));
        bloodGroup.selectByIndex(bNum);
        Driver.waitAndSendText(staffPage.adressTextbox, faker.address().fullAddress(), 2);
        Driver.waitAndSendText(staffPage.descriptionTextbox, faker.job().title());
        Select user = new Select(staffPage.userDropbox);
        user.selectByVisibleText("ahmet");
        Select country = new Select(staffPage.countryDropbox);
        int cNum = Math.abs(rn.nextInt(4));
        country.selectByIndex(cNum);
        Select state = new Select(staffPage.cstateDropbox);
        int sNum = Math.abs(rn.nextInt(2));
        System.out.println(sNum);
        state.selectByIndex(sNum);

    }

    @Given("click save")
    public void click_save() throws InterruptedException {
        Thread.sleep(3000);
        Driver.waitAndClick(staffPage.savebutton);

    }

    @Then("verify if it is registered")
    public void verify_if_it_is_registered() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertTrue(staffPage.toastifSuccess.getText().equals("A new Staff is created with identifier 4755"));

    }


}
