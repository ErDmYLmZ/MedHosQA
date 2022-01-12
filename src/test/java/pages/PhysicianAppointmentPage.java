package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysicianAppointmentPage {

    public PhysicianAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//table/tbody/tr[3]/td[13]/div/a/span/span")
    public WebElement edit;
}
