package dieutester.com.testcases;

import dieutester.com.common.BaseTest;
import dieutester.com.pages.AddNewCategoryPage;
import dieutester.com.pages.AllCategoriesPage;
import dieutester.com.pages.LoginPage;
import dieutester.com.pages.MenuHomePage;
import org.testng.annotations.Test;

public class AddNewCategoryTest extends BaseTest {
    AddNewCategoryPage addNewCategoryPage;
    AllCategoriesPage allCategoriesPage;
    LoginPage loginPage;
    MenuHomePage menuHomePage;

    @Test
    public void testAddNewCategory() {
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin@example.com", "123456");

        menuHomePage = new MenuHomePage(driver);
        menuHomePage.clickMenuCategory();

        allCategoriesPage = new AllCategoriesPage(driver);
        allCategoriesPage.verifyAllCategoriesPage();
        allCategoriesPage.clickAddNewcategoryButton();

        addNewCategoryPage = new AddNewCategoryPage(driver);
        addNewCategoryPage.AddNewCategory("CategoryDMTT");

    }
}
