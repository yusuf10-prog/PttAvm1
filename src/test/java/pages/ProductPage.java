package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "button.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "button.buy-now")
    private WebElement buyNowButton;

    @FindBy(css = "div.product-quantity")
    private WebElement quantitySelector;

    @FindBy(css = "button.increase-quantity")
    private WebElement increaseQuantityButton;

    @FindBy(css = "button.decrease-quantity")
    private WebElement decreaseQuantityButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public void buyNow() {
        clickElement(buyNowButton);
    }

    public void increaseQuantity() {
        clickElement(increaseQuantityButton);
    }

    public void decreaseQuantity() {
        clickElement(decreaseQuantityButton);
    }
}
