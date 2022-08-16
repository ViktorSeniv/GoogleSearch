import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SaitTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void checkImageSearch(){
        driver.findElement(By.xpath("//a[@data-pid='2']")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("image", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(driver.findElement(By.xpath("//img[@alt = 'Maximally optimizing image loading for the web']")).isEnabled());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
