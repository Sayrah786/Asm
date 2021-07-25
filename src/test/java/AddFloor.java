import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddFloor {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void addFloorAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[1]/div/a")).click();
        driver.findElement(By.xpath("//*[@data-original-title='Add Floor']")).click();
        driver.findElement(By.id("txtFloor")).sendKeys("nine");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        String msg=driver.findElement(By.xpath("//*[@id=\"you\"]/h4")).getText();
        if(msg.equalsIgnoreCase("Success !")){
            System.out.println("Floor add successfully");

        }




    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
