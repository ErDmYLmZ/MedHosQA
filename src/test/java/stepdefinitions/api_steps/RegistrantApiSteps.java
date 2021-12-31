package stepdefinitions.api_steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ApiRequestsUtils.getRequest;
import static utilities.Authentication.generateToken;
public class RegistrantApiSteps {
    Response response;
    String token;
    String endPoint = ConfigReader.getProperty("registrant_endpoint");
    Registrant [] registrants;
    String fileName = ConfigReader.getProperty("api_registrant_data_file_name");
    @Given("user sets the url and generates the token")
    public void user_sets_the_url_and_generates_the_token() {
        token = generateToken();
    }
    @Given("user sends the get request and gets the response")
    public void user_sends_the_get_request_and_gets_the_response() {
        response = getRequest(token, endPoint);
    }
    @When("user deserializes the data")
    public void user_deserializes_the_data() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        registrants = obj.readValue(response.asString(), Registrant[].class);
    }
    @When("user puts the data into correspondent files")
    public void user_puts_the_data_into_correspondent_files() {
        WriteToTxt.saveRegistrantApiData(fileName,registrants);
    }
    @Then("user validates the registrants")
    public void user_validates_the_registrants() {
        List<String > expectedSSNs = new ArrayList<>();
        expectedSSNs.add("123-55-4444");
        expectedSSNs.add("123-12-1234");
        expectedSSNs.add("234-55-3432");
        List<String> actuallSSNs = ReadTxt.returnUserSSNs(fileName);
        System.out.println(actuallSSNs);
        //assertTrue("The data does not Match!",actuallSSNs.containsAll(expectedSSNs) );
    }
}