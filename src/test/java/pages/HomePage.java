package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import java.util.Set;

public class HomePage extends BasePage {
    @FindBy(id = "home-menu-item")
    WebElement homeMenuItem;

    @FindBy(xpath = "//a[@id='checking-menu']")
    WebElement checkingDropdown;

    @FindBy(id = "view-checking-menu-item")
    WebElement viewChecking;

    @FindBy(id = "new-checking-menu-item")
    WebElement newChecking;

    @FindBy(id = "savings-menu")
    WebElement savingsMenu;

    @FindBy(id = "view-savings-menu-item")
    WebElement viewSavingsMenu;

    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingsMenu;


    public void verifyUserIsSignedInSuccessfully() {
        Assert.assertTrue("User is not on the Home Page", homeMenuItem.isDisplayed());
    }

    public void clickOnCheckingItem() {
        checkingDropdown.click();
    }

    public void verifyCheckingOptionsAreDisplayed() {

        Assert.assertTrue(viewChecking.isDisplayed() && newChecking.isDisplayed());

    }

    public boolean verifySavingsIsDisplayed() {
        return savingsMenu.isDisplayed();
    }

    public void clickSavings() {
        savingsMenu.click();
    }

    public boolean verifyViewSavingsNewSavingsDisplayed() {
        return (viewSavingsMenu.isDisplayed() && newSavingsMenu.isDisplayed());
    }

    public void openNewSavingsInNewTab() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(newSavingsMenu).keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(2000);
        String currentWindow = driver.getWindowHandle();

        Set<String> listOfWindows = driver.getWindowHandles();
        for (String windowVar : listOfWindows) {
            if (!windowVar.equals(currentWindow))
                driver.switchTo().window(windowVar);
            Thread.sleep(2000);
        }
    }
}

