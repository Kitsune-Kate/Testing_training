package PageObjectTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ModalWindowAddProduct {
    private MainPage mainPage;
    // Конструктор
    private WebDriver driver;

    public ModalWindowAddProduct(WebDriver driver) {
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

    public void enterExotic() {
        exotic.click();
    }

    public void buttonSave(){
        save.click();
    }
    public void step(String nameEnter, String typeEnter) {
        mainPage.clickButtonAdd();
        enterName(nameEnter);
        enterType(typeEnter);
        enterExotic();
        save.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }



}
