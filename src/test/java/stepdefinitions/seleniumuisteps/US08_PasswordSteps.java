package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.PasswordPage;
import pages.RegistrationPage;
import utilities.*;

import static org.junit.Assert.*;

public class US08_PasswordSteps {
    RegistrationPage registrationPage = new RegistrationPage();
    CommonPageElements cp = new CommonPageElements();
    PasswordPage passwordPage = new PasswordPage();


//    @Given("user is on the registration page")
//    public void user_is_on_the_registration_page() {
//       // Driver.getDriver().get(ConfigReader.getProperty("app_url_register"));
//    }

    @When("user enters the first password as {string}")
    public void user_enters_the_first_password_as(String firstPassword) {
        registrationPage.firstPasswordTextbox.sendKeys(firstPassword);

    }

    @When("user confirms the same password {string}")
    public void user_confirms_the_same_password(String confirmationPassword) {
        registrationPage.newPasswordTextbox.sendKeys(confirmationPassword);
        ReusableMethods.waitFor(1);
        registrationPage.firstPasswordTextbox.click();

    }

    @And("Verify error message {string} and {string}")
    public void verifyErrorMessage(String firstPassword, String confirmationpassword) {
        if (confirmationpassword.equals("Ab12345.")) {
            String attributeOfPasswordBox = registrationPage.newPasswordTextbox.getAttribute("class");
            ReusableMethods.waitFor(1);
            Assert.assertFalse(attributeOfPasswordBox.contains("invalid"));
            System.out.println(attributeOfPasswordBox);


        } else {
            String attributeOfPasswordBox = registrationPage.newPasswordTextbox.getAttribute("class");
            ReusableMethods.waitFor(1);
            assertTrue(attributeOfPasswordBox.contains("invalid"));
            System.out.println(attributeOfPasswordBox);


        }
    }

    @And("user enters {string} and verify the strengthBar is fully green")
    public void userEntersAndVerifyTheStrengthBarIsFullyGreen(String firstpassword) {
        String barColor = passwordPage.strengthBar.getAttribute("style");
        switch (firstpassword){
            case "Ab12345.":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                Assert.assertFalse(barColor.contains("153"));
            break;
            case "AA12345.":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                assertTrue(barColor.contains("221"));
            break;
            case "ab12345.":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                assertTrue(barColor.contains("221"));
                break;
            case "Abbbbbb.":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                assertTrue(barColor.contains("221"));
                break;
            case "Ab123455":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                assertTrue(barColor.contains("221"));
                break;
            case "Ab123.":
                ReusableMethods.waitFor(2);
                System.out.println(barColor);
                assertTrue(barColor.contains("221"));
                break;
        }
//        if (firstpassword.equals("Ab12345.")) {
//            System.out.println(barColor);
//            Assert.assertFalse(barColor.contains("153"));
//
//        }else if (firstpassword.equals("Ab12345")){
//            ReusableMethods.waitForVisibility(registrationPage.strengthBar, 2);
//            System.out.println(barColor);
//            Assert.assertTrue(barColor.contains("221"));
//        }else {
//            ReusableMethods.waitForVisibility(registrationPage.strengthBar, 2);
//            System.out.println(barColor);
//            Assert.assertTrue(barColor.contains("221"));
//        }
    }

    @Then("user navigates to password")
    public void userNavigatesToPassword() {
        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        Driver.waitAndClick(passwordPage.Passwordbutton);
    }

    @And("User enters current password as {string}")
    public void userEntersCurrentPasswordAs(String password) {
        Driver.waitAndSendText(passwordPage.currentPasswordBox, password);

    }

    @And("User enters New password as the same {string}")
    public void userEntersNewPasswordAsTheSame(String password) {
        Driver.waitAndSendText(passwordPage.newPasswordBox, password);

    }

    @And("User enters New password confirmation as the same {string}")
    public void userEntersNewPasswordConfirmationAsTheSame(String password) {
        Driver.waitAndSendText(passwordPage.confirmPasswordBox, password);
    }

    @And("User clicks on Save button")
    public void userClicksOnSaveButton() {
        Driver.waitAndClick(passwordPage.saveButton);

    }

    @Then("verify the error message is displayed")
    public void verifyTheErrorMessageIsDisplayed() {
        Driver.waitAndClick(passwordPage.ToastifyMessage);
        String ToastifyMessage =passwordPage.ToastifyMessage.getText();
        assertNotEquals("Old password should not be accepted",ToastifyMessage,"Password changed!");
                System.out.println(ToastifyMessage);
        System.out.println("Silinecek");
        System.out.println("Silinecek2");
    }
}
