package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MailLoginTesting
{
    WebDriver driver;
    @BeforeClass
    @Parameters( {"browser","url"})
    void setupDriver(String browser, String link)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        driver.get(link);
        driver.manage().window().maximize(); //Full screen.
    }
    @Test
    @Parameters({"username","password"})
    //@Parameters({"username"})
    void loginMail(String username, String password) throws InterruptedException
    //void loginMail(String username) throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector("input.whsOnd")).sendKeys(username);
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
        //Thread.sleep(2000);
    }
    @AfterTest
    void closeDriver()
    {
        driver.quit();
    }
}
