package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AdminPage;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.UserPage;
import utilities.Driver;



public class US20_Admin_Manages_Users_Steps {
    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();
    UserPage userPage = new UserPage();
    AdminPage adminPage = new AdminPage();

    //TC0001 Step Defs
    @Given("Admin goes to the url")
    public void admin_goes_to_the_url() {
        //Hooks class run here
    }
    @Given("Admin should navigate to sign in page")
    public void admin_should_navigate_to_sign_in_page() {

        Driver.waitAndClick(commonPageElements.signInAndRegistrationPortal);
        Driver.waitAndClick(commonPageElements.signIn);

    }
    @Given("Admin enters username {string}")
    public void admin_enters_username(String username) {
        Driver.waitAndSendText(loginPage.username, username);
    }
    @Given("Admin enters password {string}")
    public void admin_enters_password(String password) {

        Driver.waitAndSendText(loginPage.password, password);
    }
    @Given("Admin clicks sign in button")
    public void admin_clicks_sign_in_button() {

        Driver.waitAndClick(loginPage.loginButton);
    }
    @Given("Admin clicks Administration dropdown, selects User management and clicks")
    public void admin_clicks_administration_dropdown_selects_user_management_and_clicks() {
        Driver.waitAndClick(adminPage.administrationDropdown);
        Driver.waitAndClick(adminPage.userManagement);
    }
    @Given("Admin clicks view button of an existing user")
    public void admin_clicks_view_button_of_an_existing_user() {

        Driver.clickWithJS(userPage.viewButton3313);
    }
    @Then("admin verifies registered people info as firstname, lastname, email etc.")
    public void admin_verifies_registered_people_info_as_firstname_lastname_email_etc() {
        Driver.wait(2);
        Assert.assertTrue(userPage.userFirstName.isDisplayed());
        Driver.wait(2);
        Assert.assertTrue(userPage.userLastName.isDisplayed());
        Driver.wait(2);
        Assert.assertTrue(userPage.userEmail.isDisplayed());
        Driver.wait(2);
        Assert.assertTrue(userPage.userLanguage.isDisplayed());
    }

    //TC0002 Step Defs
    @Given("Admin goes back to the Users page")
    public void admin_goes_back_to_the_users_page() {
        Driver.waitAndClick(userPage.backButton);
    }

    @Given("Admin clicks Edit button of an existing user")
    public void admin_clicks_edit_button_of_an_existing_user() {
        Driver.waitAndClick(userPage.editButton3313);
    }
    @Given("Admin edits the info, activates the account and gives role")
    public void admin_edits_the_info_activates_the_account_and_gives_role() {
        Driver.getDriver().findElement(By.id("firstName")).clear();
        Driver.waitAndSendText(userPage.firstNameBox, "Johnny");

        Driver.getDriver().findElement(By.id("lastName")).clear();
        Driver.waitAndSendText(userPage.lastNameBox, "Jones");

        Driver.waitAndClick(userPage.activatedCheckbox);
        Driver.waitAndClick(userPage.activatedCheckbox);
        Driver.waitAndClick(userPage.rolePhysician);
    }
    @Given("Admin clicks save button")
    public void admin_clicks_save_button() {
        Driver.waitAndClick(userPage.saveButton);
    }
    @Then("Admin sees success message and verifies Users text as navigates back to that page")
    public void admin_sees_success_message_and_verifies_users_text_as_navigates_back_to_that_page() {
        Driver.wait(2);
        Assert.assertTrue(userPage.usersPageText.isDisplayed());
    }

    //TC0003 Step Defs
    @Given("Admin is on the Users page")
    public void admin_is_on_the_users_page() {
        Assert.assertTrue(userPage.usersPageText.isDisplayed());
    }
    @Given("Admin clicks delete button of an account")
    public void admin_clicks_delete_button_of_an_account() {
        Driver.clickWithJS(userPage.deleteButton3313);
    }
    @Given("Admin gets Confirm delete operation message box")
    public void admin_gets_confirm_delete_operation_message_box() {
        Driver.waitForVisibility(userPage.deleteConfirmationText, 2);
        Assert.assertTrue(userPage.deleteConfirmationText.isDisplayed());
        Driver.waitAndClick(userPage.cancelButton);

    }
    @Then("admin verifies the success message and gets back to Users page")
    public void admin_verifies_the_success_message_and_gets_back_to_users_page() {

        //Driver.waitAndClick(userPage.deleteButton15);
        //Assert.assertTrue(userPage.deleteConfirmationText.isDisplayed());


    }
}
