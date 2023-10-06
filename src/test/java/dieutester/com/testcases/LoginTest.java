package dieutester.com.testcases;

import dieutester.com.common.BaseTest;
import dieutester.com.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    public void testLogin() {
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin@example.com", "123456");
    }
}
