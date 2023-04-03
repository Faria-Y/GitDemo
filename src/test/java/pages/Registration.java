package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Registration extends BasePage {

    @FindBy(id = "title")
    public WebElement titleRegistrationField;

    @FindBy(id = "firstName")
    public WebElement firstNameRegistrationField;

    @FindBy(id = "lastName")
    public WebElement lastNameRegistrationField;

    @FindBy(xpath = "//input[@value= 'M']")
    public WebElement genderMRegistrationField;

    @FindBy(xpath = "//input[@value= 'F']")
    public WebElement genderFRegistrationField;

    @FindBy(id = "dob")
    public WebElement dateOfBirthRegistrationField;

    @FindBy(id = "ssn")
    public WebElement ssnRegistrationField;

    @FindBy(id = "emailAddress")
    public WebElement emailRegistrationField;

    @FindBy(id = "password")
    public WebElement passwordRegistrationField;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordRegistrationField;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    public WebElement singInLink;

    public boolean verifyRegistrationPage() {
        return titleRegistrationField.isDisplayed();
    }

    public void fillOutStandardInfoBeforeDOB() {
        titleRegistrationField.sendKeys("Mr.");
        firstNameRegistrationField.sendKeys("StandardUser");
        lastNameRegistrationField.sendKeys("UserLastName");
        genderFRegistrationField.click();
    }

    public void clickOnDOB() {

        dateOfBirthRegistrationField.click();
    }

    public void enterDobFields(String dob) {
        dateOfBirthRegistrationField.sendKeys(dob);
    }

    public String verifyInvalidDOBErrorMsg() {

        String invalidDobErrMsg = "";
        try {
            dateOfBirthRegistrationField.sendKeys(Keys.ENTER);
            WebElement elementForDOBError = driver.findElement(By.xpath("//@*[contains(., 'format')]"));
            invalidDobErrMsg = elementForDOBError.getText();
        } catch (Exception e) {

            invalidDobErrMsg = "No error message found";

        }
        return invalidDobErrMsg;
    }

}











