package com.test.in.UIUtilityCommon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.abc.in.excelAndPropertiesFileReadWrite.PropertiesFileUtilities;

public class BaseClass {

    WebDriver driver;
    PropertiesFileUtilities readWrite = new PropertiesFileUtilities();
    String configFilePath = ".\\resources\\config.properties";
    String browserName;

    public WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\singswet.CORPDOM\\Documents\\Selenium Softwares\\Chrome Server Driver\\chromedriver.exe");
        browserName = readWrite.readDataFromPropertiesFile(configFilePath, "browser");

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }

}
