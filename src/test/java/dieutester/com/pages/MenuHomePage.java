package dieutester.com.pages;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dieutester.com.keywords.ActionKeywords.*;

public class MenuHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");

    public MenuHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    public void clickMenuCategory() {
        waitForPageLoaded();
        clickElement(menuProducts);
        clickElement(menuCategory);
    }


}
