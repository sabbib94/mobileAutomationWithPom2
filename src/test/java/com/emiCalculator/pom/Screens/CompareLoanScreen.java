package com.emiCalculator.pom.Screens;

import com.emiCalculator.pom.util.General;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareLoanScreen extends BaseScreen {
    public CompareLoanScreen(AndroidDriver driver) {
        super(driver);
    }

    public CompareLoanScreen fillLoan1Amount(int amount) {
        General.waitForDomStable();
        WebElement etLoanAmount1 = getWebElement(By.id("etLoanAmount1"));
        etLoanAmount1.clear();
        etLoanAmount1.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillInterest1(int interest) {
        General.waitForDomStable();
        WebElement etInterest1 = getWebElement(By.id("etInterest1"));
        etInterest1.clear();
        etInterest1.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoanScreen fillMonth1(int month) {
        General.waitForDomStable();
        WebElement etPeriod1 = getWebElement(By.id("etPeriod1"));
        etPeriod1.clear();
        etPeriod1.sendKeys(String.valueOf(month));
        return this;
    }

    public CompareLoanScreen fillLoan2Amount(int amount) {
        General.waitForDomStable();
        WebElement etLoanAmount1 = getWebElement(By.id("etLoanAmount2"));
        etLoanAmount1.clear();
        etLoanAmount1.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillInterest2(int interest) {
        General.waitForDomStable();
        WebElement etInterest1 = getWebElement(By.id("etInterest2"));
        etInterest1.clear();
        etInterest1.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoanScreen fillMonth2(int month) {
        General.waitForDomStable();
        WebElement etPeriod1 = getWebElement(By.id("etPeriod2"));
        etPeriod1.clear();
        etPeriod1.sendKeys(String.valueOf(month));
        return this;
    }

    public CompareLoanScreen tapCalculatorBtn() {
        General.waitForDomStable();
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public CompareLoanScreen tapResetBtn() {
        General.waitForDomStable();
        getWebElement(By.id("btnReset")).click();
        return this;
    }

//    public int getInterestAmount(){
//        String amount=getWebElement(By.className("android.widget.RelativeLayout")).getText().trim().replaceAll(",","");
//        return Integer.parseInt(amount);
//    }
    public String getEmiText(){
        String emiText=getWebElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView\n")).getText();
        return emiText;
    }

    public String getEmiAmount(){
        String emiAmount=getWebElement(By.id("com.continuum.emi.calculator:id/monthly_emi_result_1\n")).getText().trim().replaceAll(",","");
        return emiAmount;
    }

    public String getEmiMonthValue(){
        String emiMonthValue=getWebElement(By.id("com.continuum.emi.calculator:id/monthly_emi_result_2")).getText().trim().replaceAll(",","");
        return emiMonthValue;
    }

    public String getEmiDiffOne(){
        String emiDiffOne=getWebElement(By.id("com.continuum.emi.calculator:id/tvDiffOne")).getText();
        return emiDiffOne;
    }
    public boolean hasResultLayout() {
        return getWebElements(By.id("layoutTable")).size() > 0;
    }

    public boolean hasCalculatorBtn() {
        return getWebElements(By.id("btnCalculate")).size() > 0;
    }
}
