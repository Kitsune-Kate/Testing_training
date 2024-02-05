package ru.ibs.qa.steps;

import PageObjectTest.MainPage;
import PageObjectTest.ModalWindowAddProduct;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPageStepDefinition {
    private WebDriver driver;
    private MainPage mainPage;

    private int sizeBeforeAdd ;
    private ModalWindowAddProduct modalWindowAddProduct;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катя\\IdeaProjects\\Test_Project\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();

    }
    @Given("открыта страница со списком товаров по адресу {string}")
    public void открыта_страница_со_списком_товаров_по_адресу(String string) {
        driver.get(string);
        sizeBeforeAdd= mainPage.getRows().size();
    }
    @When("Нажать на Добавить")
    public void нажать_на_Добавить() {
        new MainPage(driver).clickButtonAdd();
    }
    @When("Заполнить поле Наименование словом {string}")
    public void заполнить_поле_наименование_словом(String name) {
        new ModalWindowAddProduct(driver).enterName(name);
    }
    @When("Выбрать {string} в поле Тип")
    public void выбрать_в_поле_тип(String type) {
        new ModalWindowAddProduct(driver).enterType(type);
    }
    @When("Выбрать чекбокс со значением Экзотический")
    public void выбрать_чекбокс_со_значением_экзотический() {
        new ModalWindowAddProduct(driver).enterExotic();
    }
    @When("Нажать кнопку Сохранить")
    public void нажать_кнопку_сохранить() {
        new ModalWindowAddProduct(driver).buttonSave();
    }
    @Then("Проверить отображение добавленного товара в списке товаров {string},{string}")
    public void проверить_отображение_добавленного_товара_в_списке_товаров(String name, String type) {
        int sizeAfterAdd = mainPage.getRows().size();
        Assertions.assertNotEquals(sizeBeforeAdd, sizeAfterAdd);
    }


}