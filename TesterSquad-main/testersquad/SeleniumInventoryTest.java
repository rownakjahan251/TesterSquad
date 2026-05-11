package testersquad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInventoryTest {3432

    public static void main(String[] args) throws InterruptedException {

        // ChromeDriver location
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\DELL\\Desktop\\SQA\\TesterSquad-main\\TesterSquad-main\\driver\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Open inventory web page
        driver.get("file:///C:/Users/DELL/Desktop/SQA/TesterSquad-main/TesterSquad-main/testersquad/inventory.html");

        // Enter Product ID
        driver.findElement(By.id("productId")).sendKeys("1");

        // Enter Product Name
        driver.findElement(By.id("productName")).sendKeys("Keyboard");

        // Enter Product Price
        driver.findElement(By.id("price")).sendKeys("500");

        // Enter Product Quantity
        driver.findElement(By.id("quantity")).sendKeys("10");

        // Click Add Product button
        driver.findElement(By.id("addProductBtn")).click();

        // Verify success message
        WebElement message = driver.findElement(By.id("message"));

        if (message.getText().equals("Product added successfully")) {

            System.out.println("====================================");
            System.out.println(" Selenium Test Passed Successfully ");
            System.out.println(" Product added to inventory system ");
            System.out.println("====================================");

        } else {

            System.out.println("====================================");
            System.out.println(" Selenium Test Failed ");
            System.out.println("====================================");
        }

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}