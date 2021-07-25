import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddOwner {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void addOwnerAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/a")).click();


        driver.findElement(By.xpath("//*[@data-original-title='Add Owner']")).click();


        driver.findElement(By.id("txtOwnerName")).sendKeys("sayrah");
        driver.findElement(By.id("txtOwnerEmail")).sendKeys("say@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtOwnerContact")).sendKeys("9765451235");
        driver.findElement(By.id("txtOwnerPreAddress")).sendKeys("Dabapu hous main road byndoor");
        driver.findElement(By.id("txtOwnerPerAddress")).sendKeys("Dabapu hous main road byndoor");
        driver.findElement(By.id("txtOwnerNID")).sendKeys("IN");
        driver.findElement(By.id("ChkOwnerUnit[]")).click();



        driver.findElement(By.xpath("//*[@name='submit']")).click();
        String msg=driver.findElement(By.xpath("//*[@id=\"you\"]/h4")).getText();
        System.out.println(msg);




    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
