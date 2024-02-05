package PageObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    // Конструктор
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@data-toggle='modal']")
    private WebElement buttonAdd;
    // Кнопка "Добавить"

    @FindBy (xpath = "//table[@class='table']/tbody/tr")
    private List<WebElement> rows;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getButtonAdd() {
        return buttonAdd;
    }

    public List<WebElement> getRows() {
        return rows;
    }

    public void clickButtonAdd() {
        buttonAdd.click();
    }
}
