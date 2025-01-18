package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    protected void checkAndAcceptCookies() {
        try {
            Thread.sleep(2000); // Sayfanın tam yüklenmesi için bekle
            
            // JavaScript ile çerez butonunu bul ve tıkla
            String jsClick = "document.querySelector('.cerez-popup-kapatma').click();";
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(jsClick);
            
            Thread.sleep(500);
            
            // Yedek yöntem - normal Selenium ile tıklama
            try {
                By cookieButton = By.cssSelector(".cerez-popup-kapatma");
                if (driver.findElements(cookieButton).size() > 0) {
                    WebElement button = driver.findElement(cookieButton);
                    if (button.isDisplayed()) {
                        button.click();
                    }
                }
            } catch (Exception e) {
                System.out.println("Normal tıklama başarısız: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Çerez kabul işlemi sırasında hata: " + e.getMessage());
        }
    }

    protected void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}
