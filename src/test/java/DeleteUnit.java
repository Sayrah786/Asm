import com.sayrah.configration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteUnit {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void deleteUnitAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@data-original-title='Delete']")).click();
        Alert ok=driver.switchTo().alert();
        ok.accept();
        System.out.println("Unit deleted successful");




    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
