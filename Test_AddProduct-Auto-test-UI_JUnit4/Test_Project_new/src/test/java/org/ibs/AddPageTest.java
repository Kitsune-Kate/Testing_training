package org.ibs;

import PageObjectTest.AddPage;

import PageObjectTest.MainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AddPageTest {

    private static WebDriver chromeDriver;
    private static AddPage chromePage;

    private static MainPage mainPage;


    public static AddPage getChromePage() {
        return chromePage;
    }



    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катя\\IdeaProjects\\Test_Project\\src\\main\\resources\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        chromeDriver.get("http://localhost:8080/food");
        chromePage = new AddPage(chromeDriver);
        mainPage = new MainPage(chromeDriver);
    }


    @Test
    public void orderChrome() {
        List<WebElement> list = mainPage.getRows();
        int size = list.size();
        chromePage.firstStep("Маракуйя", "FRUIT", true);
        int newSize = list.size();
        Assert.assertNotEquals(size,newSize);

    }


    @AfterClass
    public static void quit() {
        chromeDriver.quit();

    }

}
