package com.ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class PricingPageTests extends TestSetUp {
    @Parameters({"expected", "xpath"})
    @Test
    public void freeTrialButtonTest(String expected, String xpath) {
        //Get site
        String url = "https://ultimateqa.com/automation/fake-pricing-page/";
        driver.get(url);

        //Get purchase button
        WebElement purchaseButton = driver.findElement(By.xpath(xpath));
        purchaseButton.click();

        sleep(1000);

        //Verification
        String actualDestination = driver.getCurrentUrl();
        Assert.assertEquals(expected, actualDestination, "Destination URL doesn't match expected");
    }
}
