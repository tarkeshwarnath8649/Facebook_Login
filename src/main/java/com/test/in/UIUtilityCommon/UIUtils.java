package com.test.in.UIUtilityCommon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIUtils {

    // Method to insert value in a text field
    public void enterToTextField(WebElement element, String text) throws InterruptedException {
        element.sendKeys(text);
        Thread.sleep(1000);
    }

    // Method to click on a button
    public void clickOnButton(WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        element.click();

    }

}
