package stepdefinitions.api_steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US02_UserName_Email;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApiRequestsUtils.getRequest;
import static utilities.Authentication.generateToken;


public class US02_UserName_Email_Api {
    Response response;
    String token;
    String entPint = ConfigReader.getProperty("users_endpoint");
    US02_UserName_Email [] us02UserNameEmails;
    String fileName02 = ConfigReader.getProperty("fileName02");

    @Given("user set the url and generate the token")
    public void user_set_the_url_and_generate_the_token() {

        token = generateToken();
       ReusableMethods.waitFor(5);
    }

    @Given("user send the get request and gets the response")
    public void user_send_the_get_request_and_gets_the_response() {
        response = getRequest(token,entPint);

    }
    @When("user deserialize the data in to java")
    public void user_deserialize_the_data_in_to_java() throws Exception {
       ObjectMapper obj = new ObjectMapper();
        us02UserNameEmails = obj.readValue(response.asString(),US02_UserName_Email [].class);

    }
    @When("user save the data into correspondent file")
    public void user_save_the_data_into_correspondent_file() {
        WriteToTxt.saveUserApiData(fileName02,us02UserNameEmails);

    }
    @Then("user validate the usernames")
    public void user_validate_the_usernames() {
        List<String> expectedUserName = new ArrayList<>();
          expectedUserName.add("apl");
         expectedUserName.add("btrk");
        expectedUserName.add("mustafatekin");
        System.out.println("Eklediklerim ========: "+expectedUserName);

        List <String> actualUserName = ReadTxt.returnUserUserName(fileName02);

        Assert.assertTrue(actualUserName.containsAll(expectedUserName));

    }
    @Then("user validate the email")
    public void user_validate_the_email() {
        List<String> expectedEmail = new ArrayList<>();
           expectedEmail.add("apl@email.com");
          expectedEmail.add("btrk@qa.team");
        expectedEmail.add("mustafa@qa.team");
        System.out.println("Eklediklerim ========: "+expectedEmail);

        List <String> actualEmail = ReadTxt.returnUserEmail(fileName02);

        Assert.assertTrue(actualEmail.containsAll(expectedEmail));
    }


}
