package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input#email")
    private WebElement emailInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "button.login-button")
    private WebElement submitButton;

    @FindBy(css = "a.forgot-password")
    private WebElement forgotPasswordLink;

    @FindBy(css = "a.register-link")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickSubmit() {
        clickElement(submitButton);
    }

    public void clickForgotPassword() {
        clickElement(forgotPasswordLink);
    }

    public void clickRegister() {
        clickElement(registerLink);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
