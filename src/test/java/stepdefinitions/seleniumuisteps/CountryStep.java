package stepdefinitions.seleniumuisteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPageElements;
import pages.CountryPage;
import pojos.Country;
import utilities.Driver;

public class CountryStep {
    CountryPage countryPage = new CountryPage();
    CommonPageElements cp = new CommonPageElements();
    Country country = new Country();
    @Given("user navigates to titles")
    public void user_navigates_to_titles() {
        Driver.waitAndClick(cp.titlesAllUsers);
    }
    @Given("user clicks on country")
    public void user_clicks_on_country() {
        Driver.waitAndClick(countryPage.country);
    }
    @When("user clicks on create country")
    public void user_clicks_on_create_country() {
        Driver.waitAndClick(countryPage.createCountry);
    }
    @Given("user provides a valid country {string}")
    public void user_provides_a_valid_country(String countryName) {
        Driver.waitAndSendText(countryPage.nameTextbox,countryName );
        country.setName(countryName);
    }
    @Then("user validates the country has been created")
    public void user_validates_the_country_has_been_created() {
        Driver.waitAndClick(countryPage.saveButton);
    }
}