package dieutester.com.pages;

import dieutester.com.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.*;
import static dieutester.com.keywords.ActionKeywords.*;

public class AddNewCategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");
    private By inputName = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("//button[@title='No Parent']");
    private By inputSearchParentCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By optionParentCategory = By.xpath("//span[normalize-space()='Demo category 1']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownType = By.xpath("//button[@title='No Parent']");
    private By listOptionType = By.xpath("//select[@name='digital']");
    private By buttonBrowserBanner = By.xpath("(//div[contains(text(),'Browse')])[1]");
    private By inputSearchBannerFile = By.xpath("//input[@placeholder='Search your files']");
    private By ImageBanner = By.xpath("//div[@title='icon.jpg']//img[@class='img-fit']");
    private By buttonAddFilesBanner = By.xpath("//button[normalize-space()='Add Files']");
    private By inputSearchIconFile = By.xpath("//input[@placeholder='Search your files']");
    private By ImageIcon = By.xpath("//div[@title='Fpt-icon.png']//img[@class='img-fit']");
    private By buttonAddFilesIcon = By.xpath("//button[normalize-space()='Add Files']");
    private By buttonBrowserIcon = By.xpath("(//div[contains(text(),'Browse')])[2]");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilteringAttributes = By.xpath("//button[@title='Nothing selected']");
    private By inputSearchFilteringAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    public AddNewCategoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    public void selectParentCategory(String parentCategoryName) {
        clickElement(dropdownParentCategory);
        getWebElement(inputSearchParentCategory).sendKeys(parentCategoryName, Keys.ENTER);
    }

    public void selectFilteringAttributes(String filteringAttributesName) {
        clickElement(dropdownFilteringAttributes);
        getWebElement(inputSearchFilteringAttributes).sendKeys(filteringAttributesName, Keys.ENTER);
    }

    public void selectBanner(String bannerName) {
        clickElement(buttonBrowserBanner);
        waitForElementVisible(inputSearchBannerFile);
        getWebElement(inputSearchBannerFile).sendKeys(bannerName, Keys.ENTER);
        clickElement(ImageBanner);
        clickElement(buttonAddFilesBanner);
        sleep(5);
    }

    public void selectIcon(String iconName) {
        waitForElementPresent(buttonBrowserIcon,5);
        clickElement(buttonBrowserIcon);
        waitForElementVisible(inputSearchIconFile);
        getWebElement(inputSearchIconFile).sendKeys(iconName, Keys.ENTER);
        clickElement(ImageIcon);
        clickElement(buttonAddFilesIcon);
    }
    public void verifyCategoryInformationPage(){
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(headerAddNewCategory).isDisplayed(),
                "header Add NewCategory not found");
        Assert.assertEquals(getTextElement(headerAddNewCategory),HEADER_AddNewCategory,
                "header Add NewCategory not found");
    }

    public void AddNewCategory(String CATEGORY_NAME) {
        waitForPageLoaded();

        setText(inputName, CATEGORY_NAME);
        selectParentCategory("Demo category 1");
        setText(inputOrderingNumber, "1");
        selectDropdownDynamic(listOptionType, "Digital");
        selectBanner("icon");
        selectIcon("icon");
        setText(inputMetaTitle, "12");
        setText(inputMetaDescription, "2");
        selectFilteringAttributes("Size");
        clickElement(buttonSave);

        waitForPageLoaded();
    }


}
