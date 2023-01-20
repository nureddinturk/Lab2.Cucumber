package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPage {

    WebDriver driver;
    public AddTariffPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

@FindBy(tagName = "header")
    private WebElement header;


        @FindBy(id = "rental1")
        private WebElement monthlyRental;
        @FindBy(id = "local_minutes")
        private WebElement freeLocalMins;
        @FindBy(id = "inter_minutes")
        private WebElement freeIntMins;
        @FindBy(id = "sms_pack")
        private WebElement freeSmsPack;
        @FindBy(id = "minutes_charges")
        private WebElement localPerMins;
        @FindBy(id = "inter_charges")
        private WebElement intPerMin;
        @FindBy(id = "sms_charges")
        private WebElement smsPerCharge;
        @FindBy(xpath = "//input[@type='submit']")
        private WebElement submitButton;
        @FindBy(xpath = "//h2[.='Congratulation you add Tariff Plan']")
        private WebElement message;




        public void setMonthlyRental(String monthlyrental) {

           monthlyRental.sendKeys(monthlyrental);

        }

        public void setFreeLocalMinutes(String freelocalmins) {

           freeLocalMins.sendKeys(freelocalmins);
        }

        public void setFreeIntMins(String freeInterMins) {

            freeIntMins.sendKeys(freeInterMins);
        }

        public void setFreeSmsPack(String freeSMS) {

           freeSmsPack.sendKeys(freeSMS);

        }

        public void setLocalPerMins(String localperminute) {

            localPerMins.sendKeys(localperminute);
        }

        public void setIntPerMins(String intPerMins) {
           intPerMin.sendKeys(intPerMins);
        }

        public void setSmsPerCharge(String smsPerCharge1) {
            smsPerCharge.sendKeys(smsPerCharge1);
        }

        public void clickSubmit() {
            submitButton.click();

        }

        public void verifyMessage(String expectedMessage) {

            Assert.assertEquals(message.getText(), expectedMessage);
            driver.quit();

        }

    public void verifyHeader(String str) {
        Assert.assertTrue(header.getText().contains(str));

    }
}
