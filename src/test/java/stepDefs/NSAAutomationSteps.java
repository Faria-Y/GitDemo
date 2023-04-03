package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.NSAAutomationPage;

public class NSAAutomationSteps {

    NSAAutomationPage nsaAutomationPage = new NSAAutomationPage();

    @Then("Page title {string} is displayed")
    public void page_title_is_displayed(String pageTitle) {
        Assert.assertEquals(pageTitle, nsaAutomationPage.newSavingsPageTitleDisplayed());
    }
    @Then("Select Savings Account Type field is displayed")
    public void select_savings_account_type_field_is_displayed() {
        Assert.assertEquals("Select Savings Account Type", nsaAutomationPage.selectSavingsAccountTypeDisplayed());

    }
    @Then("Radio button options: Savings, Money Market are displayed")
    public void radio_button_options_savings_money_market_are_displayed() {
        Assert.assertTrue("Savings Type Radio Buttons are not displayed",  nsaAutomationPage.savingsTypeRadioButtonsDisplayed());
    }
    @Then("Radio button options: Savings, Money Market are unchecked")
    public void radio_button_options_savings_money_market_are_unchecked() {
        Assert.assertTrue("Savings Type Radio Buttons are Checked", nsaAutomationPage.savingsTypeRadioButtonsUnchecked());
    }
    @Then("user filled the fields")
    public void user_filled_the_fields() {
        nsaAutomationPage.clickOnSavingsRadioButton();
        nsaAutomationPage.clickOnIndividualRadioButton();
        nsaAutomationPage.enterAccountName();
        nsaAutomationPage.enterDepositAmount("2500.00");
    }
    @When("user clicks on the Submit button")
    public void user_clicks_on_the_submit_button() {
        nsaAutomationPage.clickOnSubmitButton();
    }
    @Then("verify user is redirected to page to view saving account")
    public void verify_user_is_redirected_to_page_to_view_saving_account() {
        nsaAutomationPage.verifyUserGetSuccessfullyMessage();
    }
    @When("user clicks on the Reset button")
    public void user_clicks_on_the_reset_button() {
        nsaAutomationPage.clickOnResetButton();
    }

    @Then("verify all the filled values are reset to default")
    public void verify_all_the_filled_values_are_reset_to_default() {
        Assert.assertTrue("Savings Type Radio Buttons are Checked", nsaAutomationPage.savingsTypeRadioButtonsUnchecked());
        Assert.assertTrue("Savings Type Radio Buttons are not displayed",  nsaAutomationPage.savingsTypeRadioButtonsDisplayed());
        nsaAutomationPage.verifyAccountNameFieldIsEmpty();
        nsaAutomationPage.verifyAmountFieldIsEmpty();
    }


}
