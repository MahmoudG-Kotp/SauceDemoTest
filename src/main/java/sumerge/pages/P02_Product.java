package sumerge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P02_Product {
    WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> productNames;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(css = ".product_sort_container")
    WebElement sortingDropdown;

    public P02_Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductNames() {
        return productNames;
    }

    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(price -> price.getText()) // Get the text from each WebElement
                .map(price -> price.replace("$", "").trim()) // Remove the "$" and trim spaces
                .map(Double::parseDouble) // Convert the text to Double
                .collect(Collectors.toList());
    }

    public void sortBy(String criteria) {
        sortingDropdown.sendKeys(criteria);
    }

    public List<Double> getSortedProductPrices() {
        // Fetch all product prices using getText
        List<Double> displayedPrices = productPrices.stream()
                .map(price -> price.getText()) // Get text from each WebElement
                .map(price -> price.replace("$", "").trim()) // Remove "$" and trim spaces
                .map(Double::parseDouble) // Convert to Double
                .collect(Collectors.toList());

        // Sort the list of prices
        List<Double> sortedPrices = new ArrayList<>(displayedPrices);
        Collections.sort(sortedPrices);

        return sortedPrices;
    }




}
