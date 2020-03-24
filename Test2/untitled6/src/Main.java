import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "/Users/yangzihang/Downloads/geckodriver");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("/Users/yangzihang/Downloads/Selenium+Lab2020.xlsx"));
        WebDriver driver = new FirefoxDriver();
        driver.get("http://103.120.226.190/selenium-demo/git-repo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        int maxRow = 20;
        System.out.println(maxRow);
        for (int row = 0; row < maxRow; row++) {
            String username = sheet.getRow(row).getCell(1).getStringCellValue();
            String passnum = sheet.getRow(row).getCell(2).getStringCellValue();
//            System.out.println(username + passnum);
            WebElement user = driver.findElement(By.name("user_number"));
            user.sendKeys(username);
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys(passnum);
            WebElement btn = driver.findElement(By.cssSelector(".btn"));
            btn.click();
            WebElement text = driver.findElements(By.className("mb-2")).get(1);
            if (text.getText().equals(passnum)){
                System.out.println(username +"   true");
            }else {
                System.out.println(username +"   false");

            }
        }
        driver.close();

    }
}