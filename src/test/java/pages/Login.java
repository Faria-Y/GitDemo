package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class Login extends BasePage {


    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//title[text()='Digital Bank']")
    public WebElement title;

    @FindBy(id = "submit")
    public WebElement signInButton;

    @FindBy (xpath = "//div[contains(@class, 'alert')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(),' Sign Up Here')]")
    WebElement signUpHereLink;

    @FindBy(xpath ="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    WebElement loginErrorMessage;


    public void goToSignUpPage(){

        signUpHereLink.click();

    }
    public void verifyPageTitle() {
        Assert.assertEquals("Title is not the same", "Digital Bank", Driver.getDriver().getTitle());
    }

    public void verifySignInButtonIsDisplayed() {
        Assert.assertTrue(signInButton.isDisplayed());
    }


    public void doLogin() {

        username.sendKeys(ConfigReader.getProperty("valid.username") );
        password.sendKeys(ConfigReader.getProperty("valid.password"));

    }

    public void doLogin(String invalidUsername, String invalidPassword) {

        username.sendKeys(invalidUsername);
        password.sendKeys(invalidPassword + Keys.ENTER);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
    public void verifyUserIsOnLoginPage() {

        Assert.assertTrue("User is not on the Home Page", signUpHereLink.isDisplayed());
    }
    public void verifyLoginErrorMessageIsDisplayed(){

        Assert.assertTrue( loginErrorMessage.isDisplayed());
        System.out.println(loginErrorMessage.getText());
    }
}


