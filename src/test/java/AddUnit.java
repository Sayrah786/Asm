import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUnit {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void addUnitAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@data-original-title='Add Unit']")).click();
        Select select=new Select(driver.findElement(By.id("ddlFloor")));
        select.selectByVisibleText("seven");


        driver.findElement(By.id("txtUnit")).sendKeys("705");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        String msg=driver.findElement(By.xpath("//*[@id=\"you\"]/h4")).getText();
        if(msg.equalsIgnoreCase("Success !")){
            System.out.println("Unit add successfully");

        }




    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
