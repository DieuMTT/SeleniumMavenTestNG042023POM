package dieutester.com.testcases;

import dieutester.com.common.BaseTest;
import dieutester.com.pages.HomePage;
import dieutester.com.pages.LoginPage;
import dieutester.com.pages.products.AddNewProductPage;
import dieutester.com.pages.products.EditProductPage;
import dieutester.com.pages.products.InHouseProductsPage;
import org.testng.annotations.Test;

import static dieutester.com.constants.ConfigData.*;

public class AddNewProductTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AddNewProductPage addNewProductPage;
    InHouseProductsPage inHouseProductsPage;
    EditProductPage editProductPage;


    @Test(priority = 1)
    public void testAddNewProduct() {
        //Login
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginCMS("admin@example.com", "123456");

        //Cick on menu Add New Product
        addNewProductPage = homePage.clickMenuAddNewProduct();

        //Verify Add New Product Page
        addNewProductPage.verifyAddNewProductPage();

        //Input data
        inHouseProductsPage = addNewProductPage.testAddNewProduct(PRODUCT_NAME);

        //Search Product Name
        inHouseProductsPage.searchProduct(PRODUCT_NAME);

        //Verify Product Name after when search
        inHouseProductsPage.verifyProductNameAfterWhenSearch(PRODUCT_NAME);
    }

    @Test(priority = 2)
    public void testEditProduct() {
        //Login
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginCMS("admin@example.com", "123456");

        //Navigate to InHouseProducts Page
        inHouseProductsPage = homePage.clickMenuInHouseProducts();

        //Search Product Name need update
        inHouseProductsPage.searchProduct(PRODUCT_NAME);
        inHouseProductsPage.verifyProductNameAfterWhenSearch(PRODUCT_NAME);

        //Navigate to Edit Product Page
        editProductPage = inHouseProductsPage.clickButtonEditProduct();
        editProductPage.testEditProduct();

        // Verified Product Name After When Edit
        homePage.clickMenuInHouseProducts();
        inHouseProductsPage.searchProduct(PRODUCT_NAME + " " + "Edited");
        inHouseProductsPage.verifyProductNameSearchAfterUpdated(PRODUCT_NAME + " " + "Edited");
    }

}
