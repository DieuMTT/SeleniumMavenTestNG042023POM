package dieutester.com.pages;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.*;
import static dieutester.com.keywords.ActionKeywords.*;

public class AllCategoriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By headerAllCategoriesPage = By.xpath("//h1[normalize-space()='All categories']");
    private By headerCategoriesPage = By.xpath("//h5[normalize-space()='Categories']");
    private By inputSearchType = By.xpath("//input[@id='search']");
    private By firstItemCategoryOnTable = By.xpath("//tbody/tr[1]/td[2]");
    private By buttonEditCategory = By.xpath("//i[contains(@class,'las la-edit')]");
    private By buttonDeleteCategory = By.xpath("(//i[contains(@class,'las la-trash')])[1]");
    private By messageNothingFound = By.xpath("//td[normalize-space()='Nothing found']");

    public AllCategoriesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    public void verifyAllCategoriesPage() {
        Assert.assertEquals(getCurrentUrl(), URL_categories, "The URL is not the correct categories page.");
        Assert.assertTrue(checkElementExist(headerAllCategoriesPage), "Header Page of categories not existing.");
        Assert.assertEquals(getTextElement(headerAllCategoriesPage), "All categories", "Header Page of categories page not match.");
    }

    public void clickAddNewcategoryButton() {
        waitForElementVisible(buttonAddNewCategory);
        clickElement(buttonAddNewCategory);
    }
}
