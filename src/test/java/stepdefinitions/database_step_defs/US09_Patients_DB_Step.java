package stepdefinitions.database_step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.Patient;
import utilities.ConfigReader;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class US09_Patients_DB_Step {
    List<List<Object>> actualPatientData;
    List<Object> expectedPatientData = new ArrayList<>();
    String fileName = ConfigReader.getProperty("db_patient_info");


    @Given("user sends the query to db and gets the patient data {string}")
    public void userSendsTheQueryToDbAndGetsThePatientData(String query) {
        actualPatientData = DatabaseUtility.getQueryResultList(query);
        System.out.println(actualPatientData);

    }

    @And("user saves the DB Patient data to correspondent files")
    public void userSavesTheDBPatientDataToCorrespondentFiles() {
        WriteToTxt.saveDBPatientData(fileName, actualPatientData);

    }

    @Then("user validates DB Patient data")
    public void userValidatesDBPatientData() {
        List<String> actualPatientIdDbData = ReadTxt.returnPatientIdDbData(fileName);
        System.out.println(actualPatientIdDbData);

        List<String> expectedPatientIdDbData = new ArrayList<>();
        expectedPatientIdDbData.add("4862");
        expectedPatientIdDbData.add("2551");
        expectedPatientIdDbData.add("4861");
        expectedPatientIdDbData.add("4863");
        expectedPatientIdDbData.add("3360");
        expectedPatientIdDbData.add("6805");
        expectedPatientIdDbData.add("4851");
        expectedPatientIdDbData.add("7056");


        System.out.println(expectedPatientIdDbData);
        assertTrue("The Data for Patient ids are not matching!!", actualPatientIdDbData.containsAll(expectedPatientIdDbData));
    }

}

