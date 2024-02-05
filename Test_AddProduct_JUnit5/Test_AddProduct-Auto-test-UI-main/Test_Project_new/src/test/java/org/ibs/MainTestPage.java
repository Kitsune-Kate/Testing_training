package org.ibs;
import PageObjectTest.AddPage;
import PageObjectTest.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;



public class MainTestPage {
    private static WebDriver driver;
    private static MainPage page;
    private static AddPage chromePage;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катя\\IdeaProjects\\Test_Project\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.get("http://localhost:8080/food");
        page = new MainPage(driver);
        chromePage = new AddPage(driver);
    }

    @Test
    public void clickButtonAdd() {
        page.clickButtonAdd();
        Assertions.assertEquals("http://localhost:8080/food", driver.getCurrentUrl());

    }

    @Test
    public void tableSize() {
        List<WebElement> rows = page.getRows();
        int prevRows = rows.size();


    }


}
