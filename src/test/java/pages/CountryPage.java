package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CountryPage {


    public  CountryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Country']")
    public WebElement country;
    @FindBy(xpath = "//*[text()='Create a new Country']")
    public WebElement createCountry;//*[@name ='name']
    @FindBy(name = "name")
    public WebElement nameTextbox;//*[text()='Save']
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;









}
