package dieutester.com.pages.products;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.*;
import static dieutester.com.keywords.ActionKeywords.*;


public class EditProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headerEditProductPage = By.xpath("//h1[normalize-space()='Edit Product']");
    private By inputProductName = By.xpath("//label[normalize-space()='Product Name']/following-sibling::div/input");
    private By buttonUpdateProduct = By.xpath("//form[@id='choice_form']//button[normalize-space()='Update Product']");

    public EditProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new ActionKeywords(driver);
    }

    public void testEditProduct() {
        waitForPageLoaded();
        setText(inputProductName, " " + "Edited");
        clickElement(buttonUpdateProduct);
        waitForPageLoaded();
    }
}
