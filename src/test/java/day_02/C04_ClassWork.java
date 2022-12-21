package day_02;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C04_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //chromu actim
        driver.manage().window().maximize();    //pencereyi buyuttum
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://amazon.com");

        //Search(ara) “city bike”
      WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
      aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Arama sonuc yazisi : " +aramaSonucYazisi.get(0).getText());

        //Arama sonuc sayisini konsala yazdiriniz
        String [] sonucSayisi = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println("sonucSayisi : "+ sonucSayisi[2]);

        //Sonuc sayisini Lamp'da ile yazdiriniz
        Arrays.stream(aramaSonucYazisi.get(0).getText().split(" ")).limit(3).skip(2).forEach(System.out::println);

        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> ilkWE = driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();













    }
}
