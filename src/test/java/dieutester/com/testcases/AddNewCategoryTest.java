package dieutester.com.testcases;

import dieutester.com.common.BaseTest;
import dieutester.com.pages.*;
import org.testng.annotations.Test;

import static dieutester.com.constants.ConfigData.*;

public class AddNewCategoryTest extends BaseTest {
    AddNewCategoryPage addNewCategoryPage;
    AllCategoriesPage allCategoriesPage;
    LoginPage loginPage;
    HomePage homePage;
    CategoryInformationPage categoryInformationPage;

    @Test(priority = 1)
    public void testAddNewCategory() {
        //Login
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginCMS("admin@example.com", "123456");

        //Click vào nút Menu Category

        allCategoriesPage = homePage.clickMenuCategory();

        //Kiểm tra trang All Categories Page load được hay chưa và đúng hay chưa
        allCategoriesPage.verifyAllCategoriesPage();

        //Click vào Button Add New Category
        addNewCategoryPage = allCategoriesPage.clickAddNewCategoryButton();

        //Kiểm tra trang Category Information Page load được hay chưa và đúng hay chưa
        addNewCategoryPage.verifyCategoryInformationPage();

        //Add New Category
        addNewCategoryPage.AddNewCategory(CATEGORY_NAME);

        //Search giá trị Category vừa Add
        allCategoriesPage.searchCategory(CATEGORY_NAME);

        //Verify Category Name vừa search đúng không
        allCategoriesPage.verifyCategoryNameAfterSearch(CATEGORY_NAME);

        //Check data của Category Name vừa add đúng không
        categoryInformationPage = allCategoriesPage.clickEditCategoryButton();
        categoryInformationPage.verifyCategoryInformationPage();
        categoryInformationPage.checkCategoryInformationPage(CATEGORY_NAME);
    }

    @Test(priority = 2)
    public void testDeleteCategory() {
        //Login
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginCMS("admin@example.com", "123456");

        //Click vào nút Menu Category
        allCategoriesPage = homePage.clickMenuCategory();

        //Kiểm tra trang All Categories Page load được hay chưa và đúng hay chưa
        allCategoriesPage.verifyAllCategoriesPage();

        //Search giá trị Category
        allCategoriesPage.searchCategory(CATEGORY_NAME);

        //Verify Category Name vừa search đúng không
        allCategoriesPage.verifyCategoryNameAfterSearch(CATEGORY_NAME);

        //Delete Category
        allCategoriesPage.deleteCategory();

        //Search giá trị Category vừa delete
        allCategoriesPage.searchCategory(CATEGORY_NAME);

        //Verify Category Name vừa delete
        allCategoriesPage.verifyCategoryNameAfterDelete();
    }
}
