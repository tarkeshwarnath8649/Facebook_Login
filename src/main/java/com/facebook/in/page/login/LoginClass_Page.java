package com.facebook.in.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.abc.in.excelAndPropertiesFileReadWrite.PropertiesFileUtilities;
import com.test.in.UIUtilityCommon.UIUtils;

import common.Logger;

public class LoginClass_Page {
    


        WebDriver driver;
        PropertiesFileUtilities readWrite = new PropertiesFileUtilities();
        UIUtils keywords = new UIUtils();
        public Logger APP_LOGS = Logger.getLogger(LoginClass_Page.class);

        String configFilePath = "C:\\Users\\singswet.CORPDOM\\Downloads\\config.properties";

        @FindBy(how = How.ID, using = "email")
        WebElement emailTextField;

        @FindBy(how = How.XPATH, using = "//*[@id='pass']")
        WebElement passwordField;

        @FindBy(how = How.XPATH, using = "//*[@value='Log In']")
        WebElement loginButton;

        public LoginClass_Page(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        
        public void navigateToLoginPage(String url) throws InterruptedException {
            driver.get(url);
            APP_LOGS.info("Navigated to Facebook page successfuly");

            Thread.sleep(2000);
        }

        public void loginToFB() throws InterruptedException {
            keywords.enterToTextField(emailTextField, readWrite.readDataFromPropertiesFile(configFilePath, "username"));
            APP_LOGS.info("Entered email id");
            keywords.enterToTextField(passwordField, readWrite.readDataFromPropertiesFile(configFilePath, "password"));
            APP_LOGS.info("Entered field");
            keywords.clickOnButton(loginButton);
            APP_LOGS.info("Clicked on Login button");
            Thread.sleep(2000);
        }

    }


