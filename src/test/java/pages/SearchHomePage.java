package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;
public class SearchHomePage extends BasePage {
    public SearchHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='ss']")
    WebElement searchInput;

    @FindBy(xpath = "//div[@data-testid='searchbox-dates-container']")
    WebElement searchDate;

    @FindBy(xpath = "//span[contains(text(), '10')]")
    WebElement startDate;

    @FindBy(xpath = "//span[contains(text(), '15')]")
    WebElement finishDate;

    @FindBy(xpath = "//button[@data-testid='occupancy-config']")
    WebElement numberGuestsRooms;

    @FindBy(xpath = "//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 e1b7cfea84 d64a4ea64d']")
    WebElement increaseGuests;

    @FindBy(xpath = "//button[@class='fc63351274 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 e1b7cfea84 d64a4ea64d']")
    WebElement increaseRoom;

    @FindBy(xpath = "//button[@class='fc63351294 a822bdf511 e2b4ffd73d f7db01295e c938084447 a9a04704ee d285d0ebe9']")
    WebElement buttonOk;

    @FindBy(xpath = "//button[@class='fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 c938084447 f4605622ad aa11d0d5cd']")
    WebElement buttonSearch;

    @FindBy(xpath = "//h1[contains(text(), ':')]")
    WebElement searchResults;

    public void enterDestination(String destination) throws Exception {
        typeText(searchInput, destination, "Destination " + destination + " has been typed into the field!");
    }

    public void clickSearchDate() throws Exception {
        click(searchDate, "Div element " + searchDate + " has been clicked!");
    }

    public void clickStartDate() throws Exception {
        click(startDate, "Start Date " + startDate + " has been chosen!");
    }

    public void clickFinishDate() throws Exception {
        click(finishDate, "Finish Date " + finishDate + " has been chosen!");
    }

    public void clickNumberGuestsRooms() throws Exception {
        click(numberGuestsRooms, "Button " + numberGuestsRooms + " has been clicked!");
    }

    public void clickIncreaseGuests() throws Exception {
        click(increaseGuests, "Button for increase guests " + increaseGuests + " has been clicked!");
    }

    public void clickIncreaseRoom() throws Exception {
        click(increaseRoom, "Button for increase rooms " + increaseRoom + " has been clicked!");
    }

    public void clickButtonOk() throws Exception {
        click(buttonOk, "Button Ok " + buttonOk + " has been clicked!");
    }

    public void clickButtonSearch() throws Exception {
        click(buttonSearch, "Button Search " + buttonSearch + " has been clicked!");
    }

    public void searchResultsShouldBeVisible() {
        Assert.assertTrue(searchResults.isDisplayed());
    }

}
