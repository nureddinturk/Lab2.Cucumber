package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Add Tariff Plan")
    private WebElement addTariffButton;

    @FindBy(name = "googlefcPresent")
    WebElement iFrame;

    @FindBy(tagName = "header")
    private WebElement header;

    public void goToMainPage() throws IOException, InterruptedException {
        Properties prod = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\config.properties");
        prod.load(fis);
        String baseURL = prod.getProperty("baseURL");
        driver.get(baseURL);
        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();
    }

    public void navigateToAddTariff() {
        addTariffButton.click();
        SoftAssert softAssert = new SoftAssert(); // this whole block of code for to refresh the page when there is google-ad pop-up coming
       try { softAssert.assertEquals(header.isDisplayed(), false);}
        catch (Exception e){
            driver.navigate().back();
            addTariffButton.click();
        }
    }
}