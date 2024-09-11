package Timesheet;

import ReactWebsite.TestSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Timesheet extends TestSetUp{

    public void inputHours(String dayHours){
        WebElement hours = driver.findElement(By.xpath("/html//input[@id='hoursWorked']"));
        hours.sendKeys(dayHours);
        WebElement project = driver.findElement(By.className("fab-SelectToggle__placeholder"));
        project.click();
        WebElement selection = driver.findElement(By.className("fab-MenuOption__row"));
        selection.click();
        WebElement save = driver.findElement(By.className("css-8ctc8"));
        sleep(2000);
        //save.click();
    }

    @Test
    public void timesheet() {
        String monHours = "8";
        String tueHours = "8";
        String wedHours = "8";
        String thuHours = "8";
        String friHours = "8";

        String email = "jcoley@softwareinstitute.com";
        String pword = "****";

        //Go to page
        String url = "https://softwareinstitute.bamboohr.com/login.php?r=%2Fhome%2F";
        driver.get(url);

        //Click log in
        WebElement logIn = driver.findElement(By.xpath("//div[@id='microsoftSSO']//span[@class='fab-Button__text']"));
        logIn.click();
        sleep(2000);

        //Input user/password
        WebElement user = driver.findElement(By.id("i0116"));
        user.sendKeys(email);
        WebElement next = driver.findElement(By.id("idSIButton9"));
        next.click();
        sleep(1000);
        WebElement password = driver.findElement(By.id("i0118"));
        password.sendKeys(pword);
        WebElement signIn = driver.findElement(By.id("idSIButton9"));
        signIn.click();

        //Wait for 2FA
        sleep(20000);

        //Continue to home page
        WebElement yes = driver.findElement(By.id("idSIButton9"));
        yes.click();
        sleep(3000);

        //Go to timesheet page
        WebElement timesheetButton = driver.findElement(By.xpath("//div[@id='TIME_TRACKING']//section[@class='TimeTrackingWidget__summary txtCenter']/a[@href='/employees/timesheet/?id=518']"));
        timesheetButton.click();
        sleep(500);

        //Add time for monday
        WebElement monday = driver.findElement(By.xpath("/html//div[@id='js-timesheet']/div[@class='TimesheetTab']/div[@class='TimesheetContent js-timesheet-content']//form/div[3]/div[@class='TimesheetSlat__dataWrapper']/div[@class='TimesheetSlat__data']/div[@class='TimesheetSlat__multipleContent']/a[@class='TimesheetSlat__addEntryLink']"));
        monday.click();
        sleep(100);
        inputHours(monHours);
        sleep(500);

        //Add time for tuesday
        WebElement tuesday = driver.findElement(By.xpath("/html//div[@id='js-timesheet']/div[@class='TimesheetTab']/div[@class='TimesheetContent js-timesheet-content']//form/div[4]/div[@class='TimesheetSlat__dataWrapper']/div[@class='TimesheetSlat__data']/div[@class='TimesheetSlat__multipleContent']/a[@class='TimesheetSlat__addEntryLink']"));
        tuesday.click();
        sleep(100);
        inputHours(tueHours);
        sleep(500);

        //Add time for wednesday
        WebElement wednesday = driver.findElement(By.xpath("/html//div[@id='js-timesheet']/div[@class='TimesheetTab']/div[@class='TimesheetContent js-timesheet-content']//form/div[5]/div[@class='TimesheetSlat__dataWrapper']/div[@class='TimesheetSlat__data']/div[@class='TimesheetSlat__multipleContent']/a[@class='TimesheetSlat__addEntryLink']"));
        wednesday.click();
        sleep(100);
        inputHours(wedHours);
        sleep(500);

        //Add time for thursday
        WebElement thursday = driver.findElement(By.xpath("/html//div[@id='js-timesheet']/div[@class='TimesheetTab']/div[@class='TimesheetContent js-timesheet-content']//form/div[6]/div[@class='TimesheetSlat__dataWrapper']/div[@class='TimesheetSlat__data']/div[@class='TimesheetSlat__multipleContent']/a[@class='TimesheetSlat__addEntryLink']"));
        thursday.click();
        sleep(100);
        inputHours(thuHours);
        sleep(500);

        //Add time for friday
        WebElement friday = driver.findElement(By.xpath("/html//div[@id='js-timesheet']/div[@class='TimesheetTab']/div[@class='TimesheetContent js-timesheet-content']//form/div[7]/div[@class='TimesheetSlat__dataWrapper']/div[@class='TimesheetSlat__data']/div[@class='TimesheetSlat__multipleContent']/a[@class='TimesheetSlat__addEntryLink']"));
        friday.click();
        sleep(100);
        inputHours(friHours);
    }
}
