package com.emiCalculator.pom.Screens;

import com.emiCalculator.pom.util.General;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    private By btnStart = By.id("btnStart");

    private By btnCompare = By.id("btnCompare");

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorScreen tabOnEmiCalculatorBtn() {
        General.waitForDomStable();
        getWebElement(btnStart).click();
        return getInstance(EmiCalculatorScreen.class);
    }

    public CompareLoanScreen tabOnCompareLoanBtn() {
        General.waitForDomStable();
        getWebElement(btnCompare).click();
        return getInstance(CompareLoanScreen.class);
    }

    public boolean hasEmiCalculatorBtn() {
        General.waitForDomStable();
        return getWebElements(btnStart).size() > 0;
    }

    public boolean hasCompareLoanBtn() {
        General.waitForDomStable();
        return getWebElements(btnCompare).size() > 0;
    }
}
