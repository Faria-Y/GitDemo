package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class BasePage {
        WebDriver driver = Driver.getDriver();

        public BasePage(){
            PageFactory.initElements(driver,this);
        }
    }


