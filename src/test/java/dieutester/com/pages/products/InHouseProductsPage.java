package dieutester.com.pages.products;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static dieutester.com.keywords.ActionKeywords.*;

public class InHouseProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headerAllProductPage = By.xpath("//h1[normalize-space()='All products']");
    private By buttonEditProduct = By.xpath("(//i[contains(@class,'las la-edit')])[1]");
    private By inputSearchProduct = By.xpath("//form[@id='sort_products']//input[@id='search']");
    private By firstItemProductOnTable = By.xpath("(//span[@class='text-muted text-truncate-2'])[1]");

    public InHouseProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new ActionKeywords(driver);
    }

    public void searchProduct(String productName) {
        waitForPageLoaded();
        getWebElement(inputSearchProduct).sendKeys(productName, Keys.ENTER);
        sleep(4);
    }

    public void verifyProductNameAfterWhenSearch(String productName) {
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(firstItemProductOnTable).isDisplayed(),
                "Fail.Product Name does not display");
        Assert.assertEquals(getTextElement(firstItemProductOnTable), productName,
                "Fail.Product Name does not match");
    }
    public void verifyProductNameSearchAfterUpdated(String productName) {
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(firstItemProductOnTable).isDisplayed(),
                "Fail.Product Name does not display");
        Assert.assertEquals(getTextElement(firstItemProductOnTable), productName,
                "Fail.Product Name does not match");
    }

    public EditProductPage clickButtonEditProduct() {
        waitForPageLoaded();
        clickElement(buttonEditProduct);
        waitForPageLoaded();
        return new EditProductPage(driver);
    }




}
