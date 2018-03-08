package Page.Object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Описываем обекты
    private By logInButton = By.xpath("//button[@id='id_submit_btn']");
    private By signUpButton = By.xpath("//button[@class='button button_white button_sm']");
    private By resetPasswordLink = By.xpath("//a[@class='register__reset-link']");
    private By emailField = By.xpath("//input[@id='id_username']");
    private By passwordField = By.xpath("//input[@id='id_password']");
    private By pageName = By.xpath("//h1[@class='register__title']");
    private By errorMSG = By.xpath("//div[@class='register__popup popup_active popup_attention register__popup-red popup-fix-cover-others']");
    public By blockedMSG = By.xpath("//span[@id='login_attempts_exceeded']");

    //Оптсываем методы работы с елементами

    @Step("Click on [Login] button")
    public ScoringDetailsPage clickLogInButton () {
        driver.findElement(logInButton).click();
        return new ScoringDetailsPage(driver);
    }
    @Step("Click on 'Reset password' link")
    public ResetPasswordPage clickResetPasswordLink () {
        driver.findElement(resetPasswordLink).click();
        return new ResetPasswordPage(driver);
    }

    /*@Step("Click on [Sign up] button")
    public SignUpPage clickSignUpButton () {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }*/
    @Step("Enter email")
    public LoginPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    @Step("Enter password")
    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Verify the login page ")
    public String getPageName() {
        return driver.findElement(pageName).getText();
    }

    public String getErrorMSG() {
        return driver.findElement(errorMSG).getText();
    }

    @Step("Verify the text of message")
    public String getBlockedMSG() {
        return driver.findElement(blockedMSG).getText();
    }

    @Step("Warning message is displayed")
    public boolean BlockedMSG() {
        return driver.findElement(blockedMSG).isDisplayed();
    }

    @Step("Login with email: {0} and password: {1}")
    public ScoringDetailsPage login(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        this.clickLogInButton();
        return new ScoringDetailsPage(driver);
    }
}
