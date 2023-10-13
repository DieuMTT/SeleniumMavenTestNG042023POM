package dieutester.com.pages.products;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

import static dieutester.com.constants.ConfigData.*;
import static dieutester.com.keywords.ActionKeywords.*;

public class AddNewProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Add  New Product
    private By headerAddNewProductPage = By.xpath("//h5[normalize-space()='Add New Product']");
    private By headerProductInformationPage = By.xpath("//h5[normalize-space()='Product Information']");
    private By inputProductName = By.xpath("//label[.='Product Name *']/following-sibling::div//input");
    private By dropdownCategory = By.xpath("//label[contains(.,'Category *')]/following-sibling::div//button");
    private By inputSearchCategory = By.xpath("//div[@id='category']//input[@type='search']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//label[.='Minimum Purchase Qty *']/following-sibling::div/input");
    private By inputTags = By.xpath("//label[.='Tags *']/following-sibling::div//tags");

    //Product price + stock
    private By headerProductPriceStock = By.xpath("//h5[normalize-space()='Product price + stock']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price *']/following-sibling::div/input");
    private By inputDiscountDateRange = By.xpath("//label[normalize-space()='Discount Date Range']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div/input");
    private By listDiscountType = By.xpath("//select[@name='discount_type']");
    private By dropdownDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div//div/button");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");
    private By inputSKU = By.xpath("//label[normalize-space()='SKU']/following-sibling::div/input");
    private By inputExternalLink = By.xpath("//label[normalize-space()='External link']/following-sibling::div/input");
    private By inputExternalLinkButtonText = By.xpath("//label[normalize-space()='External link button text']/following-sibling::div/input");

    private By buttonSaveAndPublish = By.xpath("//form[@id='choice_form']//button[normalize-space()= 'Save & Publish']");


    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new ActionKeywords(driver);
    }

    public void selectCategoryName(String categoryName) {
        waitForElementVisible(dropdownCategory);
        clickElement(dropdownCategory);
        getWebElement(inputSearchCategory).sendKeys(categoryName, Keys.ENTER);
    }

    public void verifyAddNewProductPage() {
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(headerAddNewProductPage).isDisplayed(),
                "Fail.headerAddNewProductPage does not display");
        Assert.assertEquals(getTextElement(headerAddNewProductPage), "Add New Product",
                "Fail.header Add NewCategory does not match");
    }

    public InHouseProductsPage testAddNewProduct(String productName) {
        waitForPageLoaded();

        //Input Product Information
        setText(inputProductName, productName);
        selectCategoryName(CATEGORY_NAME);
        setText(inputUnit, "KG");
        setText(inputMinimumPurchaseQty, "3");
        setText(inputTags, "Tag");

        //Input Product price + stock
        setText(inputUnitPrice, "100000");
        setText(inputDiscount, "10000");
        setText(inputQuantity, "1");

        clickElement(buttonSaveAndPublish);
        waitForPageLoaded();
        return new InHouseProductsPage(driver);
    }
}
