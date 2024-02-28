package com.softwaretestingboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LumaTests extends TestSetUp {
    @Parameters({"expected", "searchTerm"})
    @Test(groups = {"SearchBar"})
    public void searchBarTest(String expected, String searchTerm) {
        //Get site
        String url = "https://magento.softwaretestingboard.com/";
        driver.get(url);

        //Perform search
        WebElement searchBar = driver.findElement(By.id("search"));
        searchBar.sendKeys(searchTerm);
        searchBar.sendKeys(Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));

        //Verification
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expected, "Destination page is not what was expected");
    }

    @Parameters({"expected", "colourId"})
    @Test(groups = {"ImageChange"})
    public void imageChangeTest(String expected, String colourId) {
        //Get site
        String url = "https://magento.softwaretestingboard.com/";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Click colour change button
        sleep(1000);
        WebElement colourChanger = driver.findElement(By.id(colourId));
        colourChanger.click();

        //Verification
        wait.until(ExpectedConditions.attributeToBe(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/radiant-tee.html']/span[@class='product-image-container']/span[@class='product-image-wrapper']/img[@alt='Radiant Tee']"), "src", expected));
        String imageSource = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/radiant-tee.html']/span[@class='product-image-container']/span[@class='product-image-wrapper']/img[@alt='Radiant Tee']")).getAttribute("src");
        Assert.assertEquals(imageSource, expected, "The wrong image is being shown");
    }
}
