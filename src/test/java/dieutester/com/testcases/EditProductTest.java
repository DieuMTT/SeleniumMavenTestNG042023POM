package dieutester.com.testcases;

import dieutester.com.common.BaseTest;
import dieutester.com.pages.HomePage;
import dieutester.com.pages.LoginPage;
import dieutester.com.pages.products.EditProductPage;
import dieutester.com.pages.products.InHouseProductsPage;
import org.testng.annotations.Test;

import static dieutester.com.constants.ConfigData.*;

public class EditProductTest extends BaseTest {
    LoginPage loginPage;
    EditProductPage editProductPage;
    HomePage homePage;
    InHouseProductsPage inHouseProductsPage;
    @Test
    public void testEditProduct() {
        //Login
        loginPage = new LoginPage(driver);
        homePage= loginPage.loginCMS("admin@example.com", "123456");

        //Click on Menu [In House Products]
        inHouseProductsPage = homePage.clickMenuInHouseProducts();

        //Search Product name need edit
        inHouseProductsPage.searchProduct(PRODUCT_NAME);

        //Verify that Product name search is correct
        inHouseProductsPage.verifyProductNameAfterWhenSearch(PRODUCT_NAME);

        //Click on button Edit Product
        editProductPage = inHouseProductsPage.clickButtonEditProduct();

        //Verify Edit Product Page is displayed
        editProductPage.verifyEditProductPage();

        //Update data
        editProductPage.testEditProduct();

        //Verify after when update
        homePage.clickMenuInHouseProducts();
        inHouseProductsPage.searchProduct(PRODUCT_NAME + " " + "Edited");
        inHouseProductsPage.verifyProductNameSearchAfterUpdated(PRODUCT_NAME + " " + "Edited");
    }

}
