package com.sayrah;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
    public void loginAdmin(WebDriver driver){
        driver.get("http://localhost:8080/ams/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("sayrah483@gamil.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        Select s=new Select((driver.findElement(By.id("ddlLoginType"))));
        s.selectByVisibleText("Admin");
        driver.findElement(By.id("login")).click();
        String name=driver.findElement(By.xpath("//*[@data-toggle='dropdown']")).getText();
        if(name.equalsIgnoreCase("Sayeedur Rahman")){
            System.out.println("Login Successful: "+name);
        }

    }
}
