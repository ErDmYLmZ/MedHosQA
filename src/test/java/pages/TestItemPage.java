package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestItemPage {
    public TestItemPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Create a new Test Item']")
    public WebElement createNewTestItem;

    @FindBy(id = "c-test-item-name")
    public WebElement name;

    @FindBy(id = "c-test-item-description")
    public WebElement description;

    @FindBy(id = "c-test-item-price")
    public WebElement price;

    @FindBy(id = "c-test-item-defaultValMin")
    public WebElement defMinValue;

    @FindBy(id = "c-test-item-defaultValMax")
    public WebElement defMaxValue;

    @FindBy(id = "c-test-item-createdDate")
    public WebElement createdDate;

    @FindBy(xpath = "//*[contains(text(),'A new Test Item')]")
    public WebElement successMessage;

    @FindBy(id="nameLabel")
    public WebElement nameLabel;

    @FindBy(id="descriptionLabel")
    public WebElement descriptionLabel;

    @FindBy(id="priceLabel")
    public WebElement priceLabel;

    @FindBy(id="defaultValMinLabel")
    public WebElement defMinValLabel;

    @FindBy(id="defaultValMaxLabel")
    public WebElement defMaxValLabel;

    @FindBy(id="createdDateLabel")
    public WebElement createdDateLabel;

    @FindBy(xpath = "//*[text()='View'][1]")
    public WebElement viewButton;

    @FindBy(xpath = "//span[text()='Are you sure you want to delete Test Item 7520?']]")
    public WebElement deleteConfirmation;

    @FindBy(xpath = "//tbody/tr[last()]//span[text()='Delete']")
    public WebElement deleteOption;

    @FindBy(xpath ="//button[@type='button']//span[contains(text(),'Delete')]")
    public WebElement deleteButton;

    @FindBy(xpath ="//span[text()='Save']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[(text()='Internal server error.')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[text()='Test Item']//parent::h2")
    public WebElement viewConfirmation;

    @FindBy(xpath = "//span[text()='Test Item']")
    public WebElement testItemDropDown;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//tbody/tr[last()]/td[2]" )
    public WebElement lastItem;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement singOut;

    @FindBy(xpath = "//div[text()='This field is required.']")
    public WebElement invalidFeedback;

    @FindBy(xpath = "//div[contains(text(),'A Test Item is deleted with identifier')]")
    public WebElement deleteConfirmMessage;

}
