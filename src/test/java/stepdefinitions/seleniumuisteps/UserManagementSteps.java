package stepdefinitions.seleniumuisteps;

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

        System.out.println(cp.paginations.size());

        boolean flag = false;
        for (int k = 2; k <cp.paginations.size()-4; k++) {
            if(flag)
                break;


            for (int i = 0; i < userNames.size(); i++) {
                if (userNames.get(i).equalsIgnoreCase(userName) || ssnIds.get(i).equalsIgnoreCase(ssn)) {

                    Driver.waitAndClick(cp.editButtons.get(i));
                    flag=true;
                    break;
                }

            }

            System.out.println(cp.paginations.get(k).getText());
            Driver.waitAndClick(cp.paginations.get(k));

        }

    }
    @Then("user validates current activities")
    public void user_validates_current_activities() {
    }
}