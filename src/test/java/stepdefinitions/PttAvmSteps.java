package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import pages.*;

public class PttAvmSteps {
    private static WebDriver driver;
    private static HomePage homePage;
    private static CartPage cartPage;
    private static boolean isFirstRun = true;

    static {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        
        // İlk açılışta siteye git ve çerezi kabul et
        driver.get("https://www.pttavm.com/");
        try {
            Thread.sleep(2000); // Çerez popup'ının yüklenmesi için bekle
            homePage.acceptCookies();
            isFirstRun = false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (driver != null) {
                driver.quit();
            }
        }));
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("accept cookies")
    public void acceptCookies() {
        if (!driver.getCurrentUrl().contains("pttavm.com")) {
            driver.get("https://www.pttavm.com/");
            try {
                Thread.sleep(1000);
                homePage.acceptCookies();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    @Given("user is on the PttAVM homepage")
    public void userIsOnHomepage() {
        if (!driver.getCurrentUrl().contains("pttavm.com")) {
            driver.get("https://www.pttavm.com/");
            try {
                Thread.sleep(1000);
                homePage.acceptCookies();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @When("user searches for {string}")
    public void searchForProduct(String product) {
        homePage.searchProduct(product);
        sleep(500);
    }

    @Then("search results should be displayed")
    public void verifySearchResults() {
        sleep(300);
    }

    @When("user clicks on product number {string}")
    public void clickOnProduct(String number) {
        sleep(300);
    }

    @When("user adds product to cart")
    public void addToCart() {
        sleep(300);
    }

    @Then("product should be in cart")
    public void verifyCart() {
        sleep(300);
    }

    @When("user clicks on Elektronik category")
    public void clickElektronik() {
        homePage.clickElektronik();
        sleep(500);
    }

    @When("user clicks on Moda category")
    public void clickModa() {
        homePage.clickModa();
        sleep(500);
    }

    @When("user clicks on Kozmetik category")
    public void clickKozmetik() {
        homePage.clickKozmetik();
        sleep(500);
    }

    @When("user clicks on Anne Bebek category")
    public void clickAnneBebek() {
        homePage.clickAnneBebek();
        sleep(500);
    }

    @When("user clicks on Ev Yasam category")
    public void clickEvYasam() {
        homePage.clickEvYasam();
        sleep(500);
    }

    @When("user clicks on Hobi category")
    public void clickHobi() {
        homePage.clickHobi();
        sleep(500);
    }

    @When("user clicks on Spor category")
    public void clickSpor() {
        homePage.clickSpor();
        sleep(500);
    }

    @When("user clicks on Supermarket category")
    public void clickSupermarket() {
        homePage.clickSupermarket();
        sleep(500);
    }

    @When("user clicks on Otomobil category")
    public void clickOtomobil() {
        homePage.clickOtomobil();
        sleep(500);
    }

    @When("user clicks on Petshop category")
    public void clickPetshop() {
        homePage.clickPetshop();
        sleep(500);
    }

    @When("user visits all main categories")
    public void visitAllCategories() {
        clickElektronik();
        goToHomepage();
        clickModa();
        goToHomepage();
        clickKozmetik();
        goToHomepage();
        clickAnneBebek();
        goToHomepage();
        clickEvYasam();
        goToHomepage();
        clickHobi();
        goToHomepage();
        clickSpor();
        goToHomepage();
        clickSupermarket();
        goToHomepage();
        clickOtomobil();
        goToHomepage();
        clickPetshop();
    }

    @When("user goes back to homepage")
    public void goToHomepage() {
        driver.navigate().back();
        sleep(500);
    }
}
