package stepdefinitions.backend_step_defs;//
//package stepdefinitions.backend_step_defs;
//
//import base_url_setup.MedunnaBaseUrl;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//
//import org.junit.Assert;
//
//import pojos.Registrant;
//import utilities.ConfigReader;
//import utilities.ReadTxt;
//import utilities.WriteToTxt;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static utilities.ApiRequestsUtils.getRequest;
//import static utilities.Authentication.generateToken;
//
//public class StaffApi extends MedunnaBaseUrl {
//    Response response;
//
//    String token;
//    String endPoint = ConfigReader.getProperty("registrant_endpoint");
//    Registrant[] registrants;
//    String fileName = ConfigReader.getProperty("api_staff_data_file_name");
//    @Given("user sets the {string} and generates the token")
//    public void user_sets_the_and_generates_the_token(String pathParam) {
//        token = generateToken();
//        spec.pathParams("first", "api", "second", pathParam);
//
//
//    }
//    @Given("user sends the get request and gets the response")
//    public void user_sends_the_get_request_and_gets_the_response() {
//        response = getRequest(token, endPoint);
//
//    }
//    @When("user deserializes the data")
//    public void user_deserializes_the_data() throws JsonProcessingException {
//        ObjectMapper obj = new ObjectMapper();
//        registrants = obj.readValue(response.asString(), Registrant[].class);
//
//    }
//    @When("user puts the data into correspondent files")
//    public void user_puts_the_data_into_correspondent_files() {
//        WriteToTxt.saveRegistrantApiData(fileName,registrants);
//
//    }
//    @Then("user validates the registrants")
//    public void user_validates_the_registrants() {
//
//
//        Assert.assertTrue(registrants.length > 0);
//
//        List<String > expectedSSNs = new ArrayList<>();
//        expectedSSNs.add("564-34-2342");
//        expectedSSNs.add("123-55-4444");
//        expectedSSNs.add("123-45-6781");
//        List<String> actuallSSNs = ReadTxt.returnUserSSNs(fileName);
//        Assert.assertTrue("The data does not Match!",actuallSSNs.containsAll(expectedSSNs) );
//
//
//
//    }
//}
