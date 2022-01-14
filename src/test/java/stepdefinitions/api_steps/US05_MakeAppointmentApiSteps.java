package stepdefinitions.api_steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import pojos.Appointment;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;


import static utilities.ApiRequestsUtils.getRequest;
import static utilities.Authentication.generateToken;
public class US05_MakeAppointmentApiSteps {
    String token;
    Response response;
    String appointmentEndpoint = ConfigReader.getProperty("appointments_endpoint");
    String fileName = ConfigReader.getProperty("api_appointment_data_file_name");
    Appointment [] appointments;
    @Given("user generates the token")
    public void user_generates_the_token() {
        token = generateToken();

    }
    @Given("user sends appointments get request")
    public void user_sends_appointments_get_request() {
        response = getRequest(token,appointmentEndpoint);
//        response.prettyPrint();
    }
    @When("user deserializes the appointment data")
    public void user_deserializes_the_appointment_data() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        appointments = obj.readValue(response.asString(), Appointment[].class);
        System.out.println("size: "+appointments.length);
    }
    @When("user saves the appointment data into correspondent files")
    public void user_saves_the_appointment_data_into_correspondent_files() {
        WriteToTxt.saveAppointmentData(fileName, appointments);

    }
    @Then("user validates the appointment")
    public void user_validates_the_appointment() {

        List<String> expectedData = new ArrayList<>();

        expectedData.add("888-33-4444");
        expectedData.add("123-32-1123");
        expectedData.add("123-65-3098");
        System.out.println(expectedData);

        // ReadTxt.returnAppointmentData(fileName);

        List<String> actualData = ReadTxt.returnAppointmentData(fileName);
        Assert.assertTrue(actualData.containsAll(expectedData));
        System.out.println(actualData);


    }
}
