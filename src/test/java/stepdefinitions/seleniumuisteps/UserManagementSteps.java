package stepdefinitions.seleniumuisteps;
import com.sun.tools.xjc.model.CElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonPageElements;
import pages.UserManagementPage;
import utilities.Driver;
import java.util.List;
public class UserManagementSteps {
    CommonPageElements cp = new CommonPageElements();
    UserManagementPage um = new UserManagementPage();
    @Given("user navigates to user management panel")
    public void user_navigates_to_user_management_panel() {
        Driver.waitAndClick(cp.administrationDropdown);
        Driver.waitAndClick(cp.userManagement);
    }
    @Given("user provides username {string} and {string} and {string}")
    public void user_provides_username_and_and(String userName, String ssn, String string3) {
//        for (int i = 0; i <um.userNames.size() ; i++) {
//            System.out.println((i+1) +". user name: "+um.userNames.get(i).getText());
//            System.out.println((i+1)+". user email: "+um.userEmails.get(i).getText());
//            System.out.println((i+1)+". user SSN id: "+um.userSSNs.get(i).getText());
//        }
        List<String > userNames      =      Driver.returnActiveElements(cp.userNames);
        List<String > ssnIds      =      Driver.returnActiveElements(cp.userSSNs);
            for (int i = 0; i < userNames.size(); i++) {
                if (userNames.get(i).equalsIgnoreCase(userName) || ssnIds.get(i).equalsIgnoreCase(ssn) ) {
                    
                    Driver.clickWithJS(cp.editButtons.get(i));
                    break;
                }
            }
        }
    @Then("user validates current activities")
    public void user_validates_current_activities() {
    }
}