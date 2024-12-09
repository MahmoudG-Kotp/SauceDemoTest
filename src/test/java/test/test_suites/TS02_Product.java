package test.test_suites;

import test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import sumerge.pages.P01_Login;
import sumerge.pages.P02_Product;

import java.util.List;

public class TS02_Product extends Hooks {

    @Test(testName = "Verify all products are displayed")
    public void verifyProductsDisplayed() {
        new P01_Login(getRootDriver()).login("standard_user", "secret_sauce");
        P02_Product productPage = new P02_Product(getRootDriver());
        Assert.assertFalse(productPage.getProductNames().isEmpty(), "Products are not displayed!");
    }

    @Test(testName = "Verify sorting functionality by price (low to high)")
    public void verifySorting() {
        // Log in
        new P01_Login(getRootDriver()).login("standard_user", "secret_sauce");

        // Navigate to Product Page and perform sorting
        P02_Product productPage = new P02_Product(getRootDriver());
        productPage.sortBy("Price (low to high)");

        // Verify prices are sorted correctly
        List<Double> sortedPrices = productPage.getSortedProductPrices();
        List<Double> displayedPrices = productPage.getProductPrices();

        Assert.assertEquals(displayedPrices, sortedPrices, "The products are not sorted by price (low to high).");
    }

}
