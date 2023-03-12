import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Pruebas {
    
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "RUTA_DEL_DRIVER");
        driver = new ChromeDriver();
        baseUrl = "https://www.elcorteingles.es/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
        driver.get(baseUrl);
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("zapatillas");
        searchBox.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/zapatillas"));
        assertTrue(driver.getCurrentUrl().contains("/zapatillas"));
    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl);
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("televisor");
        searchBox.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/televisores"));
        assertTrue(driver.getCurrentUrl().contains("/televisores"));
    }

    @Test
    public void test3() throws Exception {
        driver.get(baseUrl);
        WebElement promoBanner = driver.findElement(By.xpath("//div[@class='m-landing-promo__banner']"));
        assertTrue(promoBanner.isDisplayed());
    }

    @Test
    public void test4() throws Exception {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.xpath("//a[@title='Identifícate o Regístrate']"));
        loginLink.click();
        WebElement loginForm = driver.findElement(By.xpath("//form[@class='m-form']"));
        assertTrue(loginForm.isDisplayed());
    }

    @Test
    public void test5() throws Exception {
        driver.get(baseUrl);
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='m-cart__icon']"));
        cartIcon.click();
        WebElement emptyCartMessage = driver.findElement(By.xpath("//div[@class='m-cart__empty-message']"));
        assertTrue(emptyCartMessage.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
