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

public class US02_UserName_Email_DB {
    String fileName02DB = ConfigReader.getProperty("db_user_userName");
    List<Object> emails;
    List<Object> logins;

    @Given("user create a connection with DB using {string} , {string} and {string}")
    public void user_create_a_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);

    }

    @Given("user send the query to db and gets the column data {string} and {string},  {string}")
    public void user_send_the_query_to_db_and_gets_the_column_data_and(String query, String columnName, String columnName2) {
         emails = DatabaseUtility.getColumnData(query,columnName);
        System.out.println(emails);
         logins = DatabaseUtility.getColumnData(query,columnName2);
        System.out.println(logins);

    }
    @Given("user save the DB data to correspondent files")
    public void user_save_the_db_data_to_correspondent_files() {
        WriteToTxt.saveDBUsernameAndEmailDBData(fileName02DB, emails,logins);

    }

    @Then("user validates userName and email in DB")
    public void user_validates_userName_and_email_in_db() {
        List<String> expectedUserNames = new ArrayList<>();
        expectedUserNames.add("durkaya");
        expectedUserNames.add("heso");
        System.out.println("===========: "+expectedUserNames);

        List<String> actualUserNames = ReadTxt.returnUserUserName(fileName02DB);
        Assert.assertTrue(actualUserNames.containsAll(expectedUserNames));
        List<String> expectedEmail = new ArrayList<>();
        expectedEmail.add("datamann@gmail.com");
        expectedEmail.add("fatih1@team.qa");
        System.out.println("===========: "+expectedEmail);

        List<String> actualEmail = ReadTxt.returnUserEmail(fileName02DB);
        Assert.assertTrue(actualEmail.containsAll(expectedEmail));
    }

}
