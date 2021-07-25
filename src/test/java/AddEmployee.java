import com.sayrah.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmployee {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= configration.getDriver();


    }
    @Test
    public void addOwnerAdmin(){
        com.sayrah.Login login=new com.sayrah.Login();
        login.loginAdmin(driver);

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[5]/div/a")).click();


        driver.findElement(By.xpath("//*[@data-original-title='Add Employee']")).click();


        driver.findElement(By.id("txtEmpName")).sendKeys("sayrah");
        driver.findElement(By.id("txtEmpEmail")).sendKeys("say@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtEmpContact")).sendKeys("9765451235");
        driver.findElement(By.id("txtEmpPreAddress")).sendKeys("Dabapu hous main road byndoor");
        driver.findElement(By.id("txtEmpPerAddress")).sendKeys("Dabapu hous main road byndoor");

        driver.findElement(By.id("txtEmpNID")).sendKeys("IN");
        Select select=new Select(driver.findElement(By.id("ddlMemberType")));
        select.selectByVisibleText("sc");

        driver.findElement(By.id("txtEmpDate")).sendKeys("22/07/2021");
        driver.findElement(By.id("txtEndingDate")).sendKeys("22/07/2024");






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
