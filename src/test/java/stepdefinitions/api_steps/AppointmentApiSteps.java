package stepdefinitions.api_steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.Appointment;
import utilities.ConfigReader;
import utilities.WriteToTxt;

import static utilities.ApiRequestsUtils.getRequest;
import static utilities.ApiRequestsUtils.getRequest;
import static utilities.Authentication.generateToken;
public class AppointmentApiSteps {
    String token;
    Response response;
    String appointmentEndpoint = ConfigReader.getProperty("appointments_endpoint");
    String fileName = ConfigReader.getProperty("appointment_file_name");
    Appointment [] appointments;
    @Given("user generates token")
    public void user_generates_token() {
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
    @When("user saves the appontment data into correspondent files")
    public void user_saves_the_appontment_data_into_correspondent_files() {
        WriteToTxt.saveAppointmentData(fileName, appointments);
    }
}