import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRental {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void addOwnerAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/a")).click();


        driver.findElement(By.xpath("//*[@data-original-title='Add Rent']")).click();


        driver.findElement(By.id("txtRName")).sendKeys("sayrah");
        driver.findElement(By.id("txtREmail")).sendKeys("say@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtRContact")).sendKeys("9765451235");
        driver.findElement(By.id("txtRAddress")).sendKeys("Dabapu hous main road byndoor");
        driver.findElement(By.id("txtRentedNID")).sendKeys("IN");
        Select select=new Select(driver.findElement(By.id("ddlFloorNo")));
        select.selectByVisibleText("seven");
        Select select1=new Select(driver.findElement(By.id("ddlUnitNo")));
        select1.selectByVisibleText("704");
        driver.findElement(By.id("txtRAdvance")).sendKeys("5000");
        driver.findElement(By.id("txtRentPerMonth")).sendKeys("500");
        driver.findElement(By.id("txtRDate")).sendKeys("22/07/2021");

        Select month=new Select(driver.findElement(By.id("ddlMonth")));
        month.selectByVisibleText("Aug");
        Select year=new Select(driver.findElement(By.id("ddlYear")));
        year.selectByVisibleText("2021");




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
