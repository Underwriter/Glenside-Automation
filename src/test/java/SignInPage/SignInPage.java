package SignInPage;

import Page.Object.LoginPage;
import Page.Object.OpenBrowser;
import Page.Object.ScoringDetailsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Signin Page")
public class SignInPage extends OpenBrowser {

    @Parameters({"browser", "baseURL"})
    @BeforeMethod
    @Step("Open browser and go to login page")
    public void Precondition (String browser, String baseURL) throws Exception {
       OpenBrowser.getDriver(browser);
       driver.get(baseURL + "login");
    }

    @AfterMethod
    @Step("Close browser")
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
    @Feature("Login")
    @Test (groups = {"smoke", "regression"}, description = "Verification of the sign-in", priority = 0)
    @TmsLink("C40389")
    @Parameters({"email", "password"})
    public void C40389 (String email, String password) throws Exception {
            LoginPage loginPage = new LoginPage(driver);
            String getPageName = loginPage.getPageName();
            Assert.assertTrue(getPageName.equals("LOG-IN"));
            loginPage.typeEmail(email);
            loginPage.typePassword(password);
            loginPage.clickLogInButton();
            ScoringDetailsPage scoringDetailsPage = new ScoringDetailsPage(driver);
            String getMenuName = scoringDetailsPage.getMenuName();
            Assert.assertEquals(getMenuName, "Ihre Bonität");
    }
    @Feature("Security")
    @TmsLink ("C39318")
    @Parameters({"email", "invalid_password"})
    @Test (groups = {"smoke", "regression"}, description = "Verification of warning message appears after failing to sign-in 10 times per minute", priority = 1)
    public void C39318 (String email, String invalid_password) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String getPageName = loginPage.getPageName();
        Assert.assertTrue(getPageName.equals("LOG-IN"));
        loginPage.typeEmail(email);
        for (int i = 0; i < 10; i++) {
            loginPage.typePassword(invalid_password);
            loginPage.clickLogInButton();
        }
        Assert.assertTrue(loginPage.BlockedMSG());
        Assert.assertEquals(loginPage.getBlockedMSG(),"Um zu verhindern, dass sich Unbefugte Zugang zu Ihren Daten verschaffen, haben wir die Anzahl der Login-Versuche eingeschränkt. Bitte versuchen sie es nochmal in 62 Sekunden.");
      //  System.out.print(loginPage.getBlockedMSG());
    }

}
