package com.ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkTest extends TestSetUp {
    @Parameters({"expected", "xpath"})
    @Test(groups = {"links"})
    public void socialMediaLinkTest(String expectedUrl, String linkXpath) {
        //Get site
        String url = "https://ultimateqa.com/complicated-page";
        driver.get(url);

        //Get link element
        WebElement link = driver.findElement(By.xpath(linkXpath));
        link.click();

        sleep(1000);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Destination webpage not what was expected");
    }

    @Parameters({"name", "email", "message", "doCaptcha", "expected"})
    @Test(groups = {"forms"})
    public void messageForm(String name, String email, String message, Boolean doCaptcha, String expected) {
        //Get site
        String url = "https://ultimateqa.com/complicated-page";
        driver.get(url);

        //Fill form
        WebElement nameField = driver.findElement(By.id("et_pb_contact_name_0"));
        nameField.sendKeys(name);
        WebElement emailField = driver.findElement(By.id("et_pb_contact_email_0"));
        emailField.sendKeys(email);
        WebElement messageField = driver.findElement(By.id("et_pb_contact_message_0"));
        messageField.sendKeys(message);
        //Captcha logic
        if (doCaptcha) {
            WebElement captchaField = driver.findElement(By.xpath("/html//div[@id='main-content']/article/div[@class='entry-content']/div[@class='et-l et-l--post']//div[@class='et_pb_section et_pb_section_0 et_section_regular']/div[7]/div[2]/div[1]//form[@action='https://ultimateqa.com/complicated-page/']//input[@name='et_pb_contact_captcha_0']"));
            int firstCaptchaDigit = Integer.parseInt(captchaField.getDomAttribute("data-first_digit"));
            int secondCaptchaDigit = Integer.parseInt(captchaField.getDomAttribute("data-second_digit"));
            int captchaAnswer = firstCaptchaDigit + secondCaptchaDigit;
            String captchaAnsFinal = String.valueOf(captchaAnswer);
            captchaField.sendKeys(captchaAnsFinal);
        }

        //Click submit
        WebElement submitButton = driver.findElement(By.xpath("/html//div[@id='main-content']/article/div[@class='entry-content']//div[@class='et_pb_section et_pb_section_0 et_section_regular']/div[7]/div[2]/div[1]//form[@action='https://ultimateqa.com/complicated-page/']//button[@name='et_builder_submit_button']"));
        submitButton.click();

        sleep(2000);

        //Verification
        WebElement outputElement = driver.findElement(By.className("et-pb-contact-message"));
        String outputMessage = outputElement.getText();
        Assert.assertTrue(outputMessage.contains(expected), "Output does not contain expected result. \nExpected: " + expected + "\nActual: " + outputMessage);
    }

    @Parameters({"expected"})
    @Test(groups = {"navigation"})
    public void navigationDropdown(String expected) {
        //Get site
        String url = "https://ultimateqa.com/complicated-page";
        driver.get(url);

        //Hover nav element
        WebElement navigationElement = driver.findElement(By.id("menu-item-218225"));
        navigationElement.click();

        sleep(100);

        //Verification
        String menuContent = navigationElement.getText();
        Assert.assertTrue(menuContent.contains(expected), "Menu not showing on screen");
    }
}
