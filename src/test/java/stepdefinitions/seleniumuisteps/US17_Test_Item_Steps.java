package stepdefinitions.seleniumuisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.TestItemPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US17_Test_Item_Steps {

    TestItemPage testItem=new TestItemPage();

    @Given("user clicks on the Item&Title dropdown button and click the Test Item")
    public void userClicksOnTheItemTitleDropdownButtonAndClickTheTestItem() {

        WebElement element= Driver.getDriver().findElement(By.xpath("//*[text()='Items&Titles']"));

        element.click();
        ReusableMethods.waitFor(1);
        testItem.testItemDropDown.click();
    }
    @Given("Admin click the create new date button as {string}")
    public void adminClickTheCreateNewDateButtonAs(String arg0) {

        Driver.waitAndClick(testItem.createNewTestItem);
    }
    @And("Admin enter the valid test datas to the textbox as{string}, {string}, {string}, {string}, {string}, {string}")
    public void adminEnterTheValidTestDatasToTheTextboxAs(String name, String description, String price, String defMinValue, String defMaxValue, String createdDate) {

        Driver.waitAndSendText(testItem.name,name);
        Driver.waitAndSendText(testItem.description,description);
        Driver.waitAndSendText(testItem.price,price);
        Driver.waitAndSendText(testItem.defMinValue,defMinValue);
        Driver.waitAndSendText(testItem.defMaxValue,defMaxValue);
        Driver.waitAndSendText(testItem.createdDate,createdDate);
        Driver.waitAndClick(testItem.submitButton,1);
        Driver.waitAndClick(testItem.submitButton);
    }

    @Then("Verify the new item as {string} is displayed on table")
    public void verifyTheAlertIsDisplayed(String name) {

        Driver.wait(3);
        Assert.assertEquals(testItem.lastItem.getText(),name);

    }
    @Given("Admin enter the invalid test datas to the textbox as{string}, {string}, {string}")
    public void adminEnterTheInvalidTestDatasToTheTextboxAs(String name, String description, String price) {

        Driver.waitAndSendText(testItem.name,name);
        Driver.waitAndSendText(testItem.description,description);
        Driver.waitAndSendText(testItem.price,price);
        Driver.waitAndClick(testItem.submitButton,1);
        Driver.waitAndClick(testItem.submitButton);
    }

    @Then("verify the {string} is displayed")
    public void verifyTheIsDisplayed(String errorMessage) {

        ReusableMethods.waitFor(2);
        Assert.assertTrue(testItem.errorMessage.isDisplayed());
        ReusableMethods.waitFor(4);

    }

    @Then("Verify the items as Test Items {string}, {string}, {string}, {string}, {string}, {string} are displayed")
    public void verifyTheItemsAsTestItemsAreDisplayed(String name, String description, String price, String defMinValue, String defMaxValue, String createdDate) {

        Assert.assertTrue(testItem.nameLabel.isDisplayed());
        Assert.assertTrue(testItem.descriptionLabel.isDisplayed());
        Assert.assertTrue(testItem.priceLabel.isDisplayed());
        Assert.assertTrue(testItem.defMinValLabel.isDisplayed());
        Assert.assertTrue(testItem.defMaxValLabel.isDisplayed());
        Assert.assertTrue(testItem.createdDateLabel.isDisplayed());
    }

    @Given("Admin click the view button")
    public void adminClickTheViewButton() {
        Driver.waitAndClick(testItem.viewButton);
    }

    @Then("Verify the {string} Title is displayed")
    public void verifyTheTitleIsDisplayed(String testItemTitle) {
        Assert.assertTrue(testItem.viewConfirmation.isDisplayed());
    }

    @Given("Admin click the delete option button")
    public void adminClickTheDeleteOptionButton() {
        Driver.waitAndClick(testItem.deleteOption,2);
        ReusableMethods.waitFor(4);

    }
    @Then("Verify the {string}  delete alert is displayed")
    public void verifyTheDeleteAlertIsDisplayed(String confirmDelete) throws InterruptedException {

        //delete button i icin stale element exception veriyor
        // Driver.waitForClickablility(testItem.deleteButton,4);
        // Driver.clickWithJS(testItem.deleteButton);
        //hicbiri calismadi.try-catch le calisti. sorunu anlayamadim
        try {
            testItem.deleteButton.click();

        }catch(Exception e){
            System.out.println("failed");
        }
        Thread.sleep(3000);
        Assert.assertTrue(testItem.deleteConfirmMessage.isDisplayed());

    }
    @Then("Admin should be signOut")
    public void adminShouldBeSignOut() {
        testItem.accountMenu.click();
        Driver.sleep(1);
        testItem.singOut.click();

    }

    @Given("Admin left blank the textbox as{string},{string}")
    public void adminLeftBlankTheTextboxAs(String name, String description) {
        Driver.waitAndSendText(testItem.name,name);
        Driver.waitAndSendText(testItem.description,description);

    }

    @Then("verify the name {string} is displayed")
    public void verifyTheNameIsDisplayed(String invalidFeedback) {
        ReusableMethods.waitFor(2);
        Assert.assertEquals(invalidFeedback, testItem.invalidFeedback.getText());

    }

    @And("Admin click the delete button on the alert")
    public void adminClickTheDeleteButtonOnTheAlert() {
        Driver.waitAndClick(testItem.deleteButton);
    }
}
