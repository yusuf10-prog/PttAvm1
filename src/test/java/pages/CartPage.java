package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "button.proceed-to-checkout")
    private WebElement checkoutButton;

    @FindBy(css = "button.remove-item")
    private WebElement removeItemButton;

    @FindBy(css = "div.cart-total")
    private WebElement cartTotal;

    @FindBy(css = "button.update-cart")
    private WebElement updateCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }

    public void removeItem() {
        clickElement(removeItemButton);
    }

    public void updateCart() {
        clickElement(updateCartButton);
    }

    public String getCartTotal() {
        return getText(cartTotal);
    }
}
