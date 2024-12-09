package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hooks {
    private static WebDriver rootDriver;

    public static WebDriver getRootDriver() {
        return rootDriver;
    }

    @BeforeMethod
    public void setup() {
        rootDriver = new ChromeDriver();
        rootDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        rootDriver.manage().window().maximize();
        rootDriver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void quitBrowser() {
        rootDriver.quit();
    }
}
