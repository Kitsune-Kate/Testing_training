package org.ibs;

import PageObjectTest.ModalWindowAddProduct;
import PageObjectTest.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ModalWindowAddProductTest {

    private static WebDriver chromeDriver;
    private static ModalWindowAddProduct modalWindowAddProduct;

    private static MainPage mainPage;


    public static ModalWindowAddProduct getModalWindowAddProduct() {
        return modalWindowAddProduct;
    }


    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катя\\IdeaProjects\\Test_Project\\src\\main\\resources\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        chromeDriver.get("http://localhost:8080/food");
        modalWindowAddProduct = new ModalWindowAddProduct(chromeDriver);
        mainPage = new MainPage(chromeDriver);
    }


    @Test
    public void shouldAddProduct() {
        int sizeBeforeAdd = mainPage.getRows().size();
        modalWindowAddProduct.step("Маракуйя", "FRUIT");
        int sizeAfterAdd = mainPage.getRows().size();
        Assertions.assertNotEquals(sizeBeforeAdd, sizeAfterAdd);

    }

    @AfterEach
    public void quit() {
        chromeDriver.quit();

    }

}
