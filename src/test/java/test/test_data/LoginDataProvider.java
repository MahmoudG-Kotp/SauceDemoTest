package test.test_data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", true},
                {"invalid_user", "invalid_password", "Username and password do not match", false}
        };
    }
}
