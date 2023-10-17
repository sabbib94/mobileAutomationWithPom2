package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.Screens.BaseScreen;
import com.emiCalculator.pom.Screens.Screen;
import org.apache.commons.codec.binary.Base64;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class BaseTest {
    AndroidDriver driver;
    Screen screen;
    private Properties properties;

    public BaseTest() {
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void setupAndroid() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("udid", "44032741338386");
            capabilities.setCapability("platformVersion", "8");
            capabilities.setCapability("appPackage", "com.continuum.emi.calculator");
            capabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
            capabilities.setCapability("platformName", "Android");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            driver.startRecordingScreen();

            screen = new BaseScreen(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public AndroidDriver getWebDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        stopRecording();
        driver.quit();
    }

    private void stopRecording() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos";
        File theDir = new File(destinationPath);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
            try {
                Files.write(path, data);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void takeScreenshot(String fileName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots";
            FileUtils.copyFile(scrFile, new File(currentDir + fileName + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // for emi calculator page
    public String getEmiAmount() {
        return properties.getProperty("emiAmount");
    }

    public String getEmiInterest() {
        return properties.getProperty("emiInterest");
    }

    public String getEmiYear() {
        return properties.getProperty("emiYear");
    }

    public String getEmiMonth() {
        return properties.getProperty("emiMonth");
    }

    public String getEmiFee() {
        return properties.getProperty("emiFee");
    }

    // for compare page
    public String getCompareLone1() {
        return properties.getProperty("compareLoan1");
    }

    public String getCompareInterest1() {
        return properties.getProperty("compareInterest1");
    }

    public String getCompareMonth1() {
        return properties.getProperty("compareMonth1");
    }

    public String getCompareLone2() {
        return properties.getProperty("compareLoan2");
    }

    public String getCompareInterest2() {
        return properties.getProperty("compareInterest2");
    }

    public String getCompareMonth2() {
        return properties.getProperty("compareMonth2");
    }
}
