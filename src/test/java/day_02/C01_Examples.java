package day_02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Examples {
    public static void main(String[] args) {
        /*
        Ilk once browser'i maximize yapalim sonra tum sayfa icin maximum bekleme suresi olarak 15sn belirtelim
        1) Sirasiyla Amazon,Facebook ve youtube  sayfalarina gidelim.
        Amazon sayfasina tekrar donelim.
        Amazon sayfasinin Url'inin https://www.amazon.com/ adresine esit oldugunu test edelim
        Sayfanin konumunu ve size'ini yazdiralim
        Sayfanin konumunu ve size'ini istedigimiz sekilde ayarlayalim
        ve istedigimiz sekilde oldugunu test edelim
        ve sayfayi kapatalim
         */
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // Ilk once browser'i maximize yapalim sonra tum sayfa icin maximum bekleme suresi olarak 15sn belirtelim
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Sirasiyla Amazon,Facebook ve youtube  sayfalarina gidelim.
        driver.get("https://www.amazon.com");
        driver.get("https://www.facebook.com");
        driver.get("https://www.youtube.com");

        // Amazon sayfasina tekrar donelim.
        driver.navigate().back();
        driver.navigate().back();

        //Amazon sayfasinin Url'inin https://www.amazon.com/ adresine esit oldugunu test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("Url Testi PASSED");
        }else{
            System.out.println("Url Testi FAILED");}

        //Sayfanin konumunu ve size'ini yazdiralim
        System.out.println("Sayfanin size'i : " + driver.manage().window().getSize());
        System.out.println("Sayfanin konumu : "+ driver.manage().window().getPosition());

        //Sayfanin konumunu ve size'ini istedigimiz sekilde ayarlayalim
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));
        System.out.println("Sayfanin yeni size'i : " + driver.manage().window().getSize());
        System.out.println("Sayfanin yeni konumu : "+ driver.manage().window().getPosition());

        //ve istedigimiz sekilde oldugunu test edelim
        Dimension actualYeniSize = driver.manage().window().getSize();
        if(actualYeniSize.getWidth()==600 && actualYeniSize.getHeight()==600){
            System.out.println("Size Testi PASSED");
        }else {
            System.out.println("Size Testi FAILED");
        }
    }
}
