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

public class SearchSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    Map<String, String> data;

    SearchHomePage searchHomePage = new SearchHomePage(driver);

    @Before
    public void setup() throws Exception {
        init(browser,wait);
    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("I am on the booking home page")
    public void iAm_on_the_booking_home_page() throws Exception {
        openApp(env);
    }

    @When("I enter my desired destination {string}")
    public void i_enter_my_desired_destination(String destination) throws Exception {
        searchHomePage.enterDestination(destination);
    }

    @And("Choose the duration of the stay")
    public void choose_the_duration_of_the_stay() throws Exception {
        searchHomePage.clickSearchDate();
        searchHomePage.clickStartDate();
        searchHomePage.clickFinishDate();
        searchHomePage.clickSearchDate();
    }

    @And("Choose number of guests and rooms")
    public void choose_number_of_guests_and_rooms() throws Exception {
        searchHomePage.clickNumberGuestsRooms();
        searchHomePage.clickIncreaseGuests();
        searchHomePage.clickIncreaseRoom();
        searchHomePage.clickButtonOk();
    }

    @And("Click Search")
    public void click_search(String arg0) throws Exception {
        searchHomePage.clickButtonSearch();
    }

    @Then("Verify that the search results are displayed")
    public void verify_that_the_search_results_are_displayed() {
        searchHomePage.searchResultsShouldBeVisible();
    }

}