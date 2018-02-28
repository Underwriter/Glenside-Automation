import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

class OpenBrowser {

   static WebDriver driver;

    protected static WebDriver getDriver(String browser) {
         switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Glenside\\Glenside-Automation\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Glenside\\Glenside-Automation\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Glenside\\Glenside-Automation\\Drivers\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            case "safari":
                System.setProperty("webdriver.safari.driver", "C:\\Glenside\\Glenside-Automation\\Drivers\\MicrosoftWebDriver.exe");
                driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
