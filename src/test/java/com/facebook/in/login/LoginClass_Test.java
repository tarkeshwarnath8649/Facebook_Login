package com.facebook.in.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.abc.in.excelAndPropertiesFileReadWrite.PropertiesFileUtilities;
import com.facebook.in.page.login.LoginClass_Page;
import com.test.in.UIUtilityCommon.BaseClass;

public class LoginClass_Test extends BaseClass{

    public static WebDriver driver;
    LoginClass_Page login;
    PropertiesFileUtilities readWrite;

    @BeforeMethod
    public void preCondition() throws InterruptedException {

        driver = getDriver();
        login = new LoginClass_Page(driver);

        Thread.sleep(2000);
    }

    @Test
    @Parameters({ "url" })
    public void loginTestFB(String url) throws InterruptedException {
        login.navigateToLoginPage(url);
        login.loginToFB();

    }

    @AfterMethod
    public void closingCondition() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
