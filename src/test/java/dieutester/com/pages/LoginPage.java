package dieutester.com.pages;

import dieutester.com.constants.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dieutester.com.constants.ConfigData.URL_LOGIN;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Các Object
    private By headerPage = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password ?']");

    //Khai báo hàm  Contructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void loginCMS(String email, String password) {
        driver.get(URL_LOGIN);
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
