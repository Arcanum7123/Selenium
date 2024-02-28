package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class DelayedElementTest extends TestSetUp {
    @Parameters({"expected"})
    @Test
    public void delayedElementTest(String expected) {
        //Get site
        String url = "https://the-internet.herokuapp.com/dynamic_loading/2";
        driver.get(url);

        //Click start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button[.='Start']"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='finish']/h4[.='Hello World!']"))));

        //Verification
        String output = driver.findElement(By.xpath("//div[@id='finish']/h4[.='Hello World!']")).getText();
        Assert.assertTrue(output.contains(expected), "Output message not what was expected");
    }
}
