import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class AcceptCookies {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            
            driver.get("https://www.pttavm.com/");
            Thread.sleep(1500);
            
            By cookieButton = By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
            if (driver.findElements(cookieButton).size() > 0 && 
                driver.findElement(cookieButton).isDisplayed()) {
                driver.findElement(cookieButton).click();
                Thread.sleep(500);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
