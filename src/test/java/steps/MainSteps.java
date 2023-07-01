package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.SearchHomePage;
import tests.BaseTest;

import java.util.Map;

public class MainSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    Map<String, String> data;
    SearchHomePage searchHomePage;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        searchHomePage = new SearchHomePage(driver);
    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("I am on the booking home page")
    public void iAmOnTheBookingHomePage() throws Exception {
            openApp(env);
    }

    @When("I enter my desired destination {string}")
    public void iEnterMyDesiredDestination(String destination) throws Exception {
        searchHomePage.enterDestination(destination);
    }

    @And("Choose the duration of the stay")
    public void chooseTheDurationOfTheStay() throws Exception {
        searchHomePage.clickSearchDate();
        searchHomePage.clickStartDate();
        searchHomePage.clickFinishDate();
        searchHomePage.clickSearchDate();
    }

    @And("Choose number of guests and rooms")
    public void chooseNumberOfGuestsAndRooms() throws Exception {
        searchHomePage.clickNumberGuestsRooms();
        searchHomePage.clickIncreaseGuests();
        searchHomePage.clickIncreaseRoom();
        searchHomePage.clickButtonOk();
    }

    @And("Click Search")
    public void click(String arg0) throws Exception {
        searchHomePage.clickButtonSearch();
    }

    @Then("Verify that the search results are displayed")
    public void verifyThatTheSearchResultsAreDisplayed() {
        searchHomePage.searchResultsShouldBeVisible();
    }
}
