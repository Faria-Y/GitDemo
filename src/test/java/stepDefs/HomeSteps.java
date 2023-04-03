package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("Savings field is displayed under BANKING ACCOUNTS section")
    public void savings_field_is_displayed_under_banking_accounts_section() {

        Assert.assertTrue("Savings field is not displayed", homePage.verifySavingsIsDisplayed());
    }

    @When("user clicks on Savings field")
    public void user_clicks_on_savings_field() {
        homePage.clickSavings();
    }

    @Then("View Savings and New Savings options are displayed")
    public void view_savings_and_new_savings_options_are_displayed() {

        Assert.assertTrue("ViewSavings and NewSavings are not displayed", homePage.verifyViewSavingsNewSavingsDisplayed());

    }

    @When("user right clicks on New Savings option and chooses open in new tab")
    public void user_right_clicks_on_new_savings_option_and_chooses_open_in_new_tab() throws InterruptedException {
        homePage.openNewSavingsInNewTab();
    }

}

