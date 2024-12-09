package test.test_suites;

import test.Hooks;
import sumerge.pages.P01_Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.test_data.LoginDataProvider;

public class TS01_Login extends Hooks {

    @Test(testName = "Verify login functionality", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password, String expected, boolean isLoginSuccessful) {
        P01_Login loginPage = new P01_Login(getRootDriver());
        loginPage.login(username, password);

        if (isLoginSuccessful) {
            Assert.assertEquals(getRootDriver().getCurrentUrl(), expected);
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains(expected));
        }
    }
}
