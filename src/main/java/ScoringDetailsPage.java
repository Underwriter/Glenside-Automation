import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScoringDetailsPage {

    private WebDriver driver;

    public ScoringDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By activeMenu = By.xpath("//a[@class='header__nav-item object_margin_right  header__nav-item_active']");
   // private By logOutButton =

    @Step("Verify Scoring detail page")
    public String getMenuName() {
        return driver.findElement(activeMenu).getText();
    }
}
