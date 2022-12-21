package day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Wpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
       driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//        2- Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();

//        3 Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        if(deleteButonu.isDisplayed()){  //bir web elementin gorunur olup olmadigini indisplayed() methodu ile goruruz
            System.out.println(" Test PASSED ");
        }else {
            System.out.println("Test FAILED");
        }
//        4 Delete tusuna basin
        Thread.sleep(3000);
        deleteButonu.click();

//        5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYazisi = driver.findElement(By.xpath("//h3"));
        if (addRemoveYazisi.isDisplayed()){
            System.out.println("Test PASSED!");
        }else System.out.println("Test FAILED!");










    }
}
