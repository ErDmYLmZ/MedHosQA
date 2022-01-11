package stepdefinitions.api_steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojos.Patient;


import utilities.ApiRequestsUtils;
import utilities.ConfigReader;
import utilities.WriteToTxt;

import java.io.IOException;

import static utilities.Authentication.generateToken;
public class US09_API {
    Response response;
    String token  ;
    String endPoint = ConfigReader.getProperty("patients_endpoint_get");
    String fileName = ConfigReader.getProperty("patients_file_name_api");
    Patient patients = new Patient();
    Patient[] patientsPojo;
    @Given("user generates current token")
    public void user_generates_current_token() {
        token = generateToken();
    }
    @And("user sends the get request for patients and gets the response")
    public void userSendsTheGetRequestForPatientsAndGetsTheResponse() {
        response = ApiRequestsUtils.getRequest(token,  endPoint);
        response.prettyPrint();
    }
    @When("user deserializes the patient data")
    public void userDeserializesThePatientData() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        patientsPojo=obj.readValue(response.asString(), Patient[].class);
    }
    @And("user puts the patients data into correspondent files")
    public void userPutsThePatientsDataIntoCorrespondentFiles() throws IOException {
        WriteToTxt.savePatientsApiData(fileName, patientsPojo);
    }
}
