package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "input[placeholder='Ürün, kategori ara']")
    private WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    // Ana kategori elementleri
    @FindBy(css = "a[href*='/elektronik']")
    private WebElement elektronikLink;

    @FindBy(css = "a[href*='/moda']")
    private WebElement modaLink;

    @FindBy(css = "a[href*='/kozmetik']")
    private WebElement kozmetikLink;

    @FindBy(css = "a[href*='/anne-bebek']")
    private WebElement anneBebekLink;

    @FindBy(css = "a[href*='/ev-yasam']")
    private WebElement evYasamLink;

    @FindBy(css = "a[href*='/hobi']")
    private WebElement hobiLink;

    @FindBy(css = "a[href*='/spor']")
    private WebElement sporLink;

    @FindBy(css = "a[href*='/supermarket']")
    private WebElement supermarketLink;

    @FindBy(css = "a[href*='/otomobil']")
    private WebElement otomobilLink;

    @FindBy(css = "a[href*='/petshop']")
    private WebElement petshopLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        checkAndAcceptCookies();
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        sendKeys(searchBox, productName);
        clickElement(searchButton);
    }

    public void clickElektronik() {
        clickElement(elektronikLink);
    }

    public void clickModa() {
        clickElement(modaLink);
    }

    public void clickKozmetik() {
        clickElement(kozmetikLink);
    }

    public void clickAnneBebek() {
        clickElement(anneBebekLink);
    }

    public void clickEvYasam() {
        clickElement(evYasamLink);
    }

    public void clickHobi() {
        clickElement(hobiLink);
    }

    public void clickSpor() {
        clickElement(sporLink);
    }

    public void clickSupermarket() {
        clickElement(supermarketLink);
    }

    public void clickOtomobil() {
        clickElement(otomobilLink);
    }

    public void clickPetshop() {
        clickElement(petshopLink);
    }
}
