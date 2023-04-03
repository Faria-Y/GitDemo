package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Registration;

public class RegistrationSteps {

    Registration registration = new Registration();

//    @Given("user is on Homepage")
//    public void user_is_on_homepage() {
//
//    } //**Reused @Given("user entered correct URL") from LoginSteps class**//

//    @When("user clicks on sign Up Here link")
//    public void user_clicks_on_sign_up_here_link() {
//
//    } //**moved to LoginSteps class**//

    @Then("verify user is on the registration page")
    public void verify_user_is_on_the_registration_page() {

        Assert.assertTrue("User is not on Registration Page", registration.verifyRegistrationPage());

    }

//    @Given("user is on the Registration page")
//    public void user_is_on_the_registration_page() {
//
//    } //**duplicate method**//

    @When("user click on {string} field")
    public void user_click_on_field(String string) {

    }

    @Then("verify user can see the drop-down window with title options")
    public void verify_user_can_see_the_drop_down_window_with_title_options() {
        ;
    }

    @When("user clicks on proper {string}")
    public void user_clicks_on_proper(String string) {

    }

    @Then("verify chosen selection appears in the Title field")
    public void verify_chosen_selection_appears_in_the_title_field() {

    }

    @When("user enters {string} in first name field")
    public void user_enters_in_first_name_field(String string) {

    }

    @Then("verify first name is displayed in the first name field")
    public void verify_first_name_is_displayed_in_the_first_name_field() {
    }

    @When("user enters {string} in last name")
    public void user_enters_in_last_name(String string) {

    }

    @Then("verify Last Name is displayed in the last name field")
    public void verify_last_name_is_displayed_in_the_last_name_field() {

    }

    @Then("active radio button displays {string}")
    public void active_radio_button_displays(String string) {
    }

    @Given("user clicks on DOB field")
    public void user_clicks_on_dob_field() {
        registration.fillOutStandardInfoBeforeDOB();
        registration.clickOnDOB();
    }

    @When("user types correct {string}, {string}, {string} format")
    public void user_types_correct_format(String validDate, String validMonth, String validYear) {
        String dob = validDate + "/" + validMonth + "/" + validYear;
        registration.enterDobFields(dob);
    }

    @Then("verify DOB is displayed  in the corresponding field")
    public void verify_dob_is_displayed_in_the_corresponding_field() {

        Assert.assertEquals("No error message found", registration.verifyInvalidDOBErrorMsg());

    }
    @When("user types incorrect {string}, {string}, {string} format")
    public void user_types_incorrect_format(String invalidDate, String invalidMonth, String invalidYear) {

        String dob = invalidDate + "/" + invalidMonth + "/" + invalidYear;
        registration.enterDobFields(dob);

    }

    @Then("verify user gets an error message {string}")
    public void verify_user_gets_an_error_message(String invalidDOBFormatMsg) {

        Assert.assertEquals(invalidDOBFormatMsg, registration.verifyInvalidDOBErrorMsg());

    }

    @Given("user clicks on SSN field")
    public void user_clicks_on_ssn_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user types in correct {string} format")
    public void user_types_in_correct_format(String string) {
    }
    @Then("SSN is displayed in the SSN field")
    public void ssn_is_displayed_in_the_ssn_field() {

    }

    @When("user enters  valid {string} in the Email field")
    public void user_enters_valid_in_the_email_field(String string) {

    }
    @Then("verify email is displayed in the email field")
    public void verify_email_is_displayed_in_the_email_field() {

    }

    @Then("verify password is hidden")
    public void verify_password_is_hidden() {

    }
    @When("user types incorrect {string} format")
    public void user_types_incorrect_format(String string) {

    }

    @Then("error message is displayed prompting to enter correct format SSN")
    public void error_message_is_displayed_prompting_to_enter_correct_format_ssn() {

    }
    @When("user enters   {string} in the Email field")
    public void user_enters_in_the_email_field(String string) {

    }
    @Then("verify user gets {string} error")
    public void verify_user_gets_error(String string) {

    }


    @When("user enters {string} to the password field")
    public void user_enters_to_the_password_field(String string) {

    }


}