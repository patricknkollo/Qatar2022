/*
package com.qatar22.qatar22.seleniumtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTests {

    //Selector, cssSelector
    private  WebDriver driver;
    @BeforeAll
    void setUp(){
        //ici chromedriver.exe et chrome.exe sont mis dans le même dossier/paquet pour que le path suivant
        // puisse bien atteindre le driver lá ou il se trouve et que le browser puisse demarrer. durant cette
        // configuration il faut egalement veiller à ce que la version du chromedriver corresponde à la version
        // de chrome.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
    }
    @Test
    public void test_buteursList() {

        driver.get("http://localhost:3000");
        //driver.get("https://www.facebook.com");
        //driver.quit();
        WebElement buteurslist = driver.findElement(By.className("drawer_sidebar"));
        Assertions.assertTrue(buteurslist.isDisplayed());
        WebElement buteurBall = driver.findElement(By.className("ball"));
        Assertions.assertTrue(buteurBall.isDisplayed());

        buteurBall.click();
    }

    @Test
    public void test_payssList() {
        driver.get("http://localhost:3000");

        WebElement payslist = driver.findElement(By.id("pays"));
        Assertions.assertTrue(payslist.isDisplayed());
        WebElement buteurBall = driver.findElement(By.className("ball"));
        Assertions.assertTrue(buteurBall.isDisplayed());

        payslist.click();
    }

    @Test
    public void test_Navigation() throws InterruptedException {

        driver.get("http://localhost:3000");
        driver.navigate().to("https://facebook.com");
        Thread.sleep(10000);
        driver.navigate().back();
        WebElement payslist = driver.findElement(By.id("pays"));
        Assertions.assertTrue(payslist.isDisplayed());
        WebElement buteurBall = driver.findElement(By.className("ball"));
        Assertions.assertTrue(buteurBall.isDisplayed());
        payslist.click();
        WebElement pdfReportButton = driver.findElement(By.id("pdf-report"));
        Assertions.assertTrue(pdfReportButton.isDisplayed());
        pdfReportButton.click();
    }

    @AfterAll
    void closeAll() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
*/
