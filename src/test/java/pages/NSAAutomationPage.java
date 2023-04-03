package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;

public class NSAAutomationPage extends BasePage {

   // @FindBy(className = "card-title text-white")
  @FindBy(xpath = "//strong[text()='New Savings Account']")

    WebElement newSavingsPageTitle;

    //@FindBy(className = "form-control-label")
    @FindBy(xpath = "//strong[text()='Select Savings Account Type']")
    WebElement savingsAccountTypeMenu;

    @FindBy(id = "Savings")
    WebElement savingsRadioButton;

    @FindBy(id = "Money Market")
    WebElement moneyMarketRadioButton;

    @FindBy(xpath ="//label[@for='Individual']")
    WebElement individualRadioButton;

    @FindBy(id="name")
    WebElement accountNameField;

    @FindBy(id = "openingBalance")
    public WebElement initialDepositField;

    @FindBy(id = "newSavingsSubmit")
    public WebElement submitButton;

    @FindBy(id = "new-account-msg")
    public  WebElement successfullyMessage;

    @FindBy(id = "newSavingsReset")
    public WebElement resetButton;


    public String newSavingsPageTitleDisplayed() {

        return newSavingsPageTitle.getText();
    }

    public String selectSavingsAccountTypeDisplayed() {
        return savingsAccountTypeMenu.getText();
    }

    public boolean savingsTypeRadioButtonsDisplayed() {
        return (savingsRadioButton.isDisplayed() && moneyMarketRadioButton.isDisplayed());
    }

    public boolean savingsTypeRadioButtonsUnchecked() {
        return (!savingsRadioButton.isSelected() && !moneyMarketRadioButton.isSelected());
    }
    public void clickOnSavingsRadioButton(){
        savingsRadioButton.click();
    }
    public void clickOnIndividualRadioButton(){
        individualRadioButton.click();
    }
    public void enterAccountName(){
        accountNameField.sendKeys(ConfigReader.getProperty("checking.account.name"));
    }
    public void enterDepositAmount(String amount){

        initialDepositField.sendKeys(amount);
    }
    public void clickOnSubmitButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",submitButton);

       // submitButton.click();
    }
    public void verifyUserGetSuccessfullyMessage(){
        Assert.assertTrue(successfullyMessage.isDisplayed());
    }
    public void clickOnResetButton() {
        resetButton.click();
    }
    public void verifyAccountNameFieldIsEmpty(){
        String accountName= accountNameField.getAttribute("value");
        Assert.assertTrue(accountName.isEmpty());
    }
    public void verifyAmountFieldIsEmpty(){
        String amountField =  initialDepositField.getAttribute("value");
        Assert.assertTrue(amountField.isEmpty());
    }
}
