package dieutester.com.pages;

import dieutester.com.keywords.ActionKeywords;
import dieutester.com.pages.products.AddNewProductPage;
import dieutester.com.pages.products.InHouseProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dieutester.com.keywords.ActionKeywords.*;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuInHouseProducts = By.xpath("//ul[@id='main-menu']//span[normalize-space()='In House Products']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new ActionKeywords(driver);
    }

    public AllCategoriesPage clickMenuCategory() {
        waitForPageLoaded();
        clickElement(menuProducts);
        clickElement(menuCategory);
        return new AllCategoriesPage(driver);
    }
    public AddNewProductPage clickMenuAddNewProduct() {
       waitForElementVisible(menuProducts);
        clickElement(menuProducts);
        waitForElementVisible(menuAddNewProduct);
        clickElement(menuAddNewProduct);
        return new AddNewProductPage(driver);
    }
    public InHouseProductsPage clickMenuInHouseProducts() {
        waitForElementVisible(menuProducts);
        clickElement(menuProducts);
        waitForElementVisible(menuInHouseProducts);
        clickElement(menuInHouseProducts);
        return new InHouseProductsPage(driver);
    }




}
