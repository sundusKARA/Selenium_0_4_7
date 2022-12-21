package day_02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Webelements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // Serach bolumunu locate edelim
     // WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
      WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));

        //Search bolumunde iphone aratalim
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        /*
        Eger bir
         */

        //Amazon sayfasindaki <input> ve <a> tag'larinin sayisini yazdiriniz

        List<WebElement> inputTag = driver.findElements(By.tagName("input"));
        System.out.println("Input Tag Sayisi : "+inputTag.size());

        List<WebElement> LinklerList = driver.findElements(By.tagName("a"));
        System.out.print("Link Sayisi : "+LinklerList.size());






    }
}
