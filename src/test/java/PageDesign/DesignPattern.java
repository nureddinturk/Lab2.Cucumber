package PageDesign;

import Pages.AddTariffPage;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DesignPattern extends PageDriver {

    WebDriver driver;

    public DesignPattern() throws IOException {
        this.driver = getDriver();
    }
    public MainPage mainPage;

    public MainPage getMainPage() {
        this.driver = driver;
        return mainPage = new MainPage(driver);
    }

    public AddTariffPage addTariffPage;

    public AddTariffPage getAddTariffPage() {
        this.driver = driver;
        return addTariffPage = new AddTariffPage(driver);
    }

}
