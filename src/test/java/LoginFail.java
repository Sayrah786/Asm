import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFail {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void loginFail(){
        driver.get("http://localhost:8080/ams/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("sayrah483@gmil.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        Select s=new Select((driver.findElement(By.id("ddlLoginType"))));
        s.selectByVisibleText("Admin");
        driver.findElement(By.id("login")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]")).getText());
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
