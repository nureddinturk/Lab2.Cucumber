package PageDesign;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageDriver {

    public WebDriver driver;
    public WebDriver getDriver() throws IOException {
       Properties prod = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\config.properties");
        prod.load(fis);
        ChromeOptions options = (ChromeOptions) new ChromeOptions().setHeadless(false);
        String browser= prod.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void shutDown() throws IOException {
        driver.close();
        driver.quit();
    }

}
