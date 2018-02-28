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

    //Оптсываем методы работы с елементами

    public ScoringDetailsPage clickLogInButton () {
        driver.findElement(logInButton).click();
        return new ScoringDetailsPage(driver);
    }

    public ResetPasswordPage clickResetPasswordLink () {
        driver.findElement(resetPasswordLink).click();
        return new ResetPasswordPage(driver);
    }

    public SignUpPage clickSignUpButton () {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public LoginPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public String getPageName() {
        return driver.findElement(pageName).getText();
    }

    public ScoringDetailsPage login(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        this.clickLogInButton();
        return new ScoringDetailsPage(driver);
    }
}
