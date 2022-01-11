package stepdefinitions.database_step_defs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
public class DatabaseSteps {
    List<Object> actualData;
    String fileName = ConfigReader.getProperty("db_user_ssn");
    @Given("user creates a connection with DB using {string} , {string} and {string}")
    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
//        DatabaseUtility.createConnection(url, username,password);
    }
    @Given("user sends the query to db and gets the column data {string} and {string}")
    public void user_sends_the_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
        actualData = DatabaseUtility.getColumnData(query,columnName );
    }
    @Given("user saves the DB data to correspondent files")
    public void user_saves_the_db_data_to_correspondent_files() {
        WriteToTxt.saveDBUserData(fileName, actualData);
    }
    @Then("user validates DB data")
    public void user_validates_db_data() {
        List<String> actualSSNs = ReadTxt.returnUserSSNs(fileName);
        System.out.println(actualSSNs);
        List<String>expectedSsns = new ArrayList<>();
        expectedSsns.add("856-45-6789");
        expectedSsns.add("856-45-6789");
        expectedSsns.add("856-45-6776");
        System.out.println(expectedSsns);
        assertTrue("The Data for SSN ids are not matching!!",actualSSNs.containsAll(expectedSsns));
    }
}
