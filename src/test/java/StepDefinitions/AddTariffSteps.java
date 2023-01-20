package StepDefinitions;

import PageDesign.DesignPattern;
import Pages.AddTariffPage;
import Pages.MainPage;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class AddTariffSteps {

    public WebDriver driver;
    public DesignPattern designPattern;
    public MainPage mainPage;

    public AddTariffPage addTariffPage;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(AddTariffSteps.class);



    public AddTariffSteps(DesignPattern designPattern) throws IOException {
        this.designPattern = designPattern;
        this.mainPage = designPattern.getMainPage();
        this.addTariffPage = designPattern.getAddTariffPage();
    }

    @Given("user is on landing page")
    public void user_is_on_landing_page() throws IOException, InterruptedException {
        mainPage.goToMainPage();
    }

    @And("user clicks to Add Tariff Plan")
    public void user_clicks_to_add_tariff_plan() throws IOException, InterruptedException {
        mainPage.navigateToAddTariff();
    }

    @And("verified that {string} header is shown")
    public void verified_that_header_is_shown(String str) {
        addTariffPage.verifyHeader(str);
    }

    @When("The user wants to Add Tariff Plan details as")
    public void the_user_wants_to_add_tariff_plan_details_as(Map<String, String> dataTable) {

        addTariffPage.setMonthlyRental(dataTable.get("Monthly Rental"));
        addTariffPage.setFreeLocalMinutes(dataTable.get("Free Local Minutes"));
        addTariffPage.setFreeIntMins(dataTable.get("Free International Minutes"));
        addTariffPage.setFreeSmsPack(dataTable.get("Free SMS Pack"));
        addTariffPage.setLocalPerMins(dataTable.get("Local Per Minutes Charges"));
        addTariffPage.setIntPerMins(dataTable.get("International Per Minutes Charges"));
        addTariffPage.setSmsPerCharge(dataTable.get("Local Per Minutes Charges"));
        //needed configuration reader to place the property file
        PropertyConfigurator.configure("C:\\Users\\N\\IdeaProjects\\Lab2.Cucumber\\src\\test\\java\\TestData\\log4j.properties");
        logger.info("The from is completely filled");
    }

    @When("The user wants to Add Tariff Plan in limited details as")
    public void the_user_wants_to_add_tariff_plan_in_limited_details_as(Map<String, String> dataTable) {

        addTariffPage.setMonthlyRental(dataTable.get("Monthly Rental"));
        addTariffPage.setFreeLocalMinutes(dataTable.get("Free Local Minutes"));
        addTariffPage.setFreeIntMins(dataTable.get("Free International Minutes"));
        addTariffPage.setFreeSmsPack(dataTable.get("Free SMS Pack"));
        addTariffPage.setLocalPerMins(dataTable.get("Local Per Minutes Charges"));

    }

    @And("user clicks to submit")
    public void user_clicks_to_submit() {
        addTariffPage.clickSubmit();
        logger.info("The from is submitted");
    }

    @Then("user should get a message as {string}")
    public void user_should_get_a_message_as(String string) {
        addTariffPage.verifyMessage(string);
    }
}
