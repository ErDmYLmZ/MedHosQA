package stepdefinitions.database_step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

public class US05_MakeAppointmentDataBaseSteps {

    List<Object> actualData;
    String fileName = ConfigReader.getProperty("db_appointment_id");
    @Given("user create a connection with DB using {string}, {string} and {string}")
    public void user_create_a_connection_with_db_using_and(String url, String username, String password) {

        DatabaseUtility.createConnection(url, username, password);
    }
    @Given("user sends to query to db and gets the column data {string} and {string}")
    public void user_sends_to_query_to_db_and_gets_the_column_data_and(String query, String columnName) {

        actualData = DatabaseUtility.getColumnData(query,columnName);
        System.out.println(actualData);
    }
    @Given("user saves the DB data to correspondent files for appointment")
    public void user_saves_the_db_data_to_correspondent_files_for_appointment() {

       WriteToTxt.saveDBUserData(fileName, actualData);
    }
    @Then("user validates DB data for appointment")
    public void user_validates_db_data_for_appointment() {
        List<String> actualId = ReadTxt.returnAppointmentId(fileName);

        List<String> expectedId = new ArrayList<>();
        expectedId.add("1101");
        expectedId.add("3405");

        Assert.assertTrue(actualId.containsAll(expectedId));

    }


}
