package ListenerUtility;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.facebook.in.login.LoginClass_Test;
import com.test.in.UIUtilityCommon.BaseClass;

public class CustomListener extends BaseClass implements ITestListener {

    WebDriver driver=null;
    String screenshotPath = ".\\Screenshots\\";
    
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        
        //LoginClass_TEST.driver is used to take the same driver as in Test class where we have test methods
        TakesScreenshot ts = (TakesScreenshot) LoginClass_Test.driver;

        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath + result.getMethod().getMethodName()+".png");

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
