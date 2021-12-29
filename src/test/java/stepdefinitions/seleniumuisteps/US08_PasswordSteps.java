package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_PasswordSteps {
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_register"));
    }
    @When("user enters the password as {string}")
    public void user_enters_the_password_as(String firstPassword) {
        registrationPage.firstPasswordTextbox.sendKeys(firstPassword);

    }
    @When("user confirms the new password {string}")
    public void user_confirms_the_new_password(String secondPassword) {
        registrationPage.newPasswordTextbox.sendKeys(secondPassword);
        ReusableMethods.waitFor(1);
        registrationPage.firstPasswordTextbox.click();

    }

    @And("Verify error message")
    public void verifyNoErrorMessage() {
       // switch ("")
        String attributeOfPasswordBox=registrationPage.newPasswordTextbox.getAttribute("class");
        Assert.assertTrue(attributeOfPasswordBox.contains("invalid"));
        System.out.println(attributeOfPasswordBox);
        //Assert.assertTrue(registrationPage.passwordErrorMessage.isDisplayed());
//        if (registrationPage.passwordErrorMessage.isDisplayed()){
//            String errorMessage=registrationPage.passwordErrorMessage.getText();
//            Assert.assertEquals("The password and its confirmation do not match!", errorMessage);
//        }else{
//            Assert.assertFalse(registrationPage.passwordErrorMessage.isDisplayed());
//        }



    }
}
