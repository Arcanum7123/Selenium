package ReactWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.domsnapshot.model.StringIndex;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchTest extends TestSetUp{

    @Parameters({"sakilaExpected", "input"})
    @Test(groups = {"genreTests"})
    public void genreSearchTest(String sakilaExpected, String input) {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Enter input(s)
        WebElement searchBar = driver.findElement(By.id("SakilaGenreInput"));
        searchBar.sendKeys(input);

        //Click go
        WebElement goButton = driver.findElement(By.id("GenreSubmit"));
        goButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        //Verification
        WebElement output = driver.findElement(By.id("GenreOutput"));
        wait.until(ExpectedConditions.textToBePresentInElement(output, sakilaExpected));
        String actual = output.getText();
        Assert.assertTrue(actual.contains(sakilaExpected), "Output does not contain expected result. \nExpected to contain: " + sakilaExpected +
                "\nActual output: " + actual);
    }

    @Parameters({"firstInputBarID", "firstInput", "secondInputBarID", "secondInput", "submitButtonID", "outputID", "expected"})
    @Test(groups = {"twoInputTests"})
    public void twoBarTests(String firstInputBarID, String firstInput, String secondInputBarID, String secondInput, String submitButtonID, String outputID, String expected) {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Fill first search bar
        WebElement firstInputBar = driver.findElement(By.id(firstInputBarID));
        firstInputBar.sendKeys(firstInput);

        //Fill second search bar
        WebElement secondInputBar = driver.findElement(By.id(secondInputBarID));
        secondInputBar.sendKeys(secondInput);

        //Click go
        WebElement submitButton = driver.findElement((By.id(submitButtonID)));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        sleep(500);

        //Verification
        WebElement output = driver.findElement(By.id(outputID));
        wait.until(ExpectedConditions.textToBePresentInElement(output, expected));
        String actual = output.getText();
        Assert.assertTrue(actual.contains(expected), "Output does not contain expected result. \nExpected to contain: " + expected + "\nActual output: " + actual);
    }

    /*@Parameters({"searchType", "expected", "country"})
    @Test(groups = {"countryStuff"})
    public void countrySearch(@Optional("Capital") String searchType, String expected, String country) {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Select capital radio button
        WebElement option = driver.findElement(By.id(searchType));
        option.click();

        //Enter Finland as search term
        WebElement searchTerm = driver.findElement(By.id("Country"));
        searchTerm.sendKeys(country);

        //Click search button
        WebElement searchButton = driver.findElement(By.id("SearchButton"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        //Verification
        WebElement output = driver.findElement(By.id("Output"));
        wait.until(ExpectedConditions.textToBePresentInElement(output, expected));
        String actual = output.getText();
        Assert.assertTrue(actual.contains(expected), "Output does not contain expected result. \nExpected to contain: " + expected + "\nActual output: "
            + actual);
    }*/
}
