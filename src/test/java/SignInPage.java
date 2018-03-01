import org.testng.Assert;
import org.testng.annotations.*;

public class SignInPage extends OpenBrowser {

    @Parameters({"browser", "baseURL"})
    @BeforeMethod
    public void setUp (String browser, String baseURL) throws Exception {
       OpenBrowser.getDriver(browser);
        driver.get(baseURL + "/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Parameters({"email", "password"})
    @Test (groups = {"smoke", "regression"}, description = "Verification of the sign-in", priority = 0)
    public void C40389 (String email, String password) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String getPageName = loginPage.getPageName();
        Assert.assertTrue(getPageName.equals("LOG-IN"));
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickLogInButton();
        ScoringDetailsPage scoringDetailsPage = new ScoringDetailsPage(driver);
        String getMenuName = scoringDetailsPage.getMenuName();
        Assert.assertEquals(getMenuName,"Ihre Bonität");
    }

    @Parameters({"email", "invalid_password"})
    @Test (groups = {"smoke", "regression"}, description = "Verification of error message appears after failing to sign-in 10 times per minute", priority = 1)
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
        Assert.assertEquals(loginPage.getBlockedMSG(),"Um zu verhindern, dass sich Unbefugte Zugang zu Ihren Daten verschaffen, haben wir die Anzahl der Login-Versuche eingeschränkt. Bitte versuchen sie es nochmal in 61 Sekunden.");
        System.out.print(loginPage.getBlockedMSG());
    }

}
