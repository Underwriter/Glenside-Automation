package Page.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageName = By.xpath("//span[@class='reset-form__title']");
   /* private By logo = By.xpath("//div[@class='header__logo reset-password__logo']/a/img/@src");
    private By logInButton = By.xpath("//button[@class='reset-form__log-in-btn']");
    private By resetPasswordButton = By.xpath("//button[@class='reset-form__reset-password-btn']");*/
    private By emailField = By.xpath("//input[@id='id_email']");

/*
    private ResetPasswordPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
*/

   
}

