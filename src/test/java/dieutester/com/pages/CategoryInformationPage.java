package dieutester.com.pages;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.URL_categories;
import static dieutester.com.keywords.ActionKeywords.*;

public class CategoryInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headerCategoryInformationPage = By.xpath("//h5[normalize-space()='Category Information']");
    private By inputName = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//button");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownType = By.xpath("//label[normalize-space()='Type']/following-sibling::div//button");
    private By buttonBanner = By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div//div[normalize-space()='1 File selected']");

    private By buttonIcon = By.xpath("//label[normalize-space()='Icon (32x32)']/following-sibling::div//div[normalize-space()='1 File selected']");
    private By inputMetaTitle = By.xpath("//label[normalize-space()='Meta Title']/following-sibling::div/input");
    private By inputMetaDescription = By.xpath("//label[normalize-space()='Meta description']/following-sibling::div/textarea");
    private By inputSlug = By.xpath("//label[normalize-space()='Slug']/following-sibling::div/input");
    private By dropdownFilteringAttributes = By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button");
    private By buttonSave = By.xpath("//form[@class='p-4']/descendant::div//button[normalize-space()= 'Save']");

    public CategoryInformationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    public void verifyCategoryInformationPage() {
        waitForPageLoaded();
        Assert.assertTrue(getCurrentUrl().contains("categories"), "The URL is not the correct Category Information Page .");
        Assert.assertTrue(checkElementExist(headerCategoryInformationPage), "Header of CategoryInformationPage not existing.");
        Assert.assertEquals(getTextElement(headerCategoryInformationPage), "Category Information", "Header CategoryInformationPage not match.");
    }

    public void checkCategoryInformationPage(String categoryName) {
        waitForPageLoaded();
        System.out.println(getAttributeElement(inputName, "value"));
        System.out.println(getTextElement(dropdownParentCategory));
        System.out.println(getAttributeElement(inputOrderingNumber, "value"));
        System.out.println(getTextElement(dropdownType));
        System.out.println(getTextElement(buttonBanner));
//    System.out.println(getTextElement(buttonIcon));
        System.out.println(getAttributeElement(inputMetaTitle, "value"));
        System.out.println(getTextElement(inputMetaDescription));
        System.out.println(getAttributeElement(inputSlug, "value"));
        System.out.println(getTextElement(dropdownFilteringAttributes));

        Assert.assertEquals(getAttributeElement(inputName, "value"), categoryName, "categoryName not match");
        Assert.assertEquals(getTextElement(dropdownParentCategory), "Demo category 1", "ParentCategory not match");
        Assert.assertEquals(getAttributeElement(inputOrderingNumber, "value"), "1", "OrderingNumber not match");
        Assert.assertEquals(getTextElement(dropdownType), "Digital", "Type not match");
        Assert.assertEquals(getTextElement(buttonBanner), "1 File selected", "Banner not match");
        Assert.assertEquals(getAttributeElement(inputMetaTitle, "value"), "12", "MetaTitle not match");
        Assert.assertEquals(getAttributeElement(inputMetaDescription, "value"), "2", "Meta Description not match");
//    Assert.assertEquals(getAttributeElement(inputSlug,"value"),"", "Slug not match");
        Assert.assertEquals(getTextElement(dropdownFilteringAttributes), "Size", "FilteringAttributes not match");


    }
}
