package ReactWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchTest extends TestSetUp{

    @Parameters({"searchType", "expected", "country"})
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

        sleep(1000);
        //Why wait not working?
        //new WebDriverWait(driver, Duration.ofSeconds(10));

        //Verification
        WebElement output = driver.findElement(By.id("Output"));
        String actual = output.getText();
        Assert.assertTrue(actual.contains(expected), "Output does not contain expected result. \nExpected to contain: " + expected + "\nActual output: "
            + actual);
    }

    @Parameters({"sakilaSearchType", "sakilaExpected", "input"})
    @Test(groups = {"sakilaStuff"})
    public void filmSearch(String sakilaSearchType, String sakilaExpected, String input) {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Select radio button
        WebElement option =  driver.findElement(By.id(sakilaSearchType));
        option.click();

        //Enter input(s)
        WebElement searchBar = driver.findElement(By.id("SakilaInput"));
        searchBar.sendKeys(input);

        //Click go
        WebElement goButton = driver.findElement(By.id("SakilaSearchButton"));
        goButton.click();

        sleep(1000);

        //Verification
        WebElement output = driver.findElement(By.id("SakilaOutput"));
        String actual = output.getText();
        Assert.assertTrue(actual.contains(sakilaExpected), "Output does not contain expected result. \nExpected to contain: " + sakilaExpected +
                "\nActual output: " + actual);
    }

    /*@Test
    public void successfulCurrencySearch() {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Select capital radio button
        WebElement option = driver.findElement(By.xpath("//div[@id='root']/section/div[@class='Radio']/label[2]"));
        option.click();

        //Enter Finland as search term
        WebElement searchTerm = driver.findElement(By.id("Country"));
        searchTerm.sendKeys("Finland");

        //Click search button
        WebElement searchButton = driver.findElement(By.id("SearchButton"));
        searchButton.click();

        sleep(1000);

        //Verification
        WebElement output = driver.findElement(By.id("Output"));
        String expected = "Euro";
        String actual = output.getText();
        Assert.assertTrue(actual.contains(expected), "Output does not contain expected result. \nExpected to contain: " + expected + "\nActual output: "
                + actual);
    }

    @Test
    public void successfulCallingCodeSearch() {
        //Get website
        String url = "http://localhost:3000/";
        driver.get(url);

        //Select capital radio button
        WebElement option = driver.findElement(By.xpath("//div[@id='root']/section/div[@class='Radio']/label[3]"));
        option.click();

        //Enter Finland as search term
        WebElement searchTerm = driver.findElement(By.id("Country"));
        searchTerm.sendKeys("Finland");

        //Click search button
        WebElement searchButton = driver.findElement(By.id("SearchButton"));
        searchButton.click();

        sleep(1000);

        //Verification
        WebElement output = driver.findElement(By.id("Output"));
        String expected = "+3";
        String actual = output.getText();
        Assert.assertTrue(actual.contains(expected), "Output does not contain expected result. \nExpected to contain: " + expected + "\nActual output: "
                + actual);
    }*/
}
