package PageObjectTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddPage {
    private MainPage mainPage;
    // Конструктор
    private WebDriver driver;

    public AddPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.mainPage = new MainPage(driver);

    }


    // поле Наименование
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameProduct;

    // поле Тип
    @FindBy(xpath = "//select[@id='type']")
    private WebElement type;

    // чекбокс Экзотический
    @FindBy(xpath = "//label[@for='exotic']")
    private WebElement exotic;

    // кнопка Сохранить
    @FindBy(xpath = "//button[@id='save']")
    private WebElement save;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement close;


    public void enterName(String nameEnter) {
        nameProduct.sendKeys(nameEnter);
    }

    public void enterType(String typeEnter) {
        type.sendKeys(typeEnter);
    }

    public void enterExotic(boolean exoticEnter) {
        exotic.click();
    }

    public void firstStep(String nameEnter, String typeEnter, boolean exoticEnter) {
        mainPage.clickButtonAdd();
        enterName(nameEnter);
        enterType(typeEnter);
        enterExotic(exoticEnter);
        save.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }



}
