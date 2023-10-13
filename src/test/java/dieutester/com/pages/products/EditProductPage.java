package dieutester.com.pages.products;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.*;
import static dieutester.com.keywords.ActionKeywords.*;


public class EditProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headerEditProductPage = By.xpath("//h1[normalize-space()='Edit Product']");

    private By inputProductName = By.xpath("//label[normalize-space()='Product Name']/following-sibling::div/input");
    private By buttonUpdateProduct = By.xpath("//form[@id='choice_form']//button[normalize-space()='Update Product']");
    private By dropdownCategory = By.xpath("//label[normalize-space()='Category']/following-sibling::div//button[@data-id='category_id']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//tags[@role='tagslist']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount']/following-sibling::div/input");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");

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
    public void verifyEditProductPage(){
        Assert.assertTrue(getWebElement(headerEditProductPage).isDisplayed(),"Fail.headerEditProductPage does not display");
        Assert.assertEquals(getWebElement(headerEditProductPage).getText(),"Edit Product","Fail.headerEditProductPage does not match");
    }
    public void verifyDataProduct(String productName){
        waitForPageLoaded();

        Assert.assertEquals(getAttributeElement(inputProductName,"value"), productName);
        Assert.assertEquals(getAttributeElement(dropdownCategory,"title"),CATEGORY_NAME);
        Assert.assertEquals(getAttributeElement(inputUnit,"value"), "KG");
//        Assert.assertEquals(getAttributeElement(inputMinimumPurchaseQty,"value"), "3");
//        Assert.assertEquals(getAttributeElement(inputTags,"value"), "Tag");
//        Assert.assertEquals(getAttributeElement(inputUnitPrice,"value"), "100000");
//        Assert.assertEquals(getAttributeElement(inputDiscount,"value"), "10000");
//        Assert.assertEquals(getAttributeElement(inputQuantity,"value"), "1");

        waitForPageLoaded();
    }
}
