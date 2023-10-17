package com.emiCalculator.pom.Screens;

import com.emiCalculator.pom.util.General;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmiCalculatorScreen extends BaseScreen{

    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorScreen fillAmount(int amount){
        General.waitForDomStable();
        WebElement etLoanAmount=getWebElement(By.id("etLoanAmount"));
        etLoanAmount.clear();
        etLoanAmount.sendKeys(String.valueOf(amount));
        return this;
    }

    public EmiCalculatorScreen fillInterest(int interest){
        General.waitForDomStable();
        WebElement etInterest=getWebElement(By.id("etInterest"));
        etInterest.clear();
        etInterest.sendKeys(String.valueOf(interest));
        return this;
    }

    public EmiCalculatorScreen fillYear(int yearNumber){
        General.waitForDomStable();
        WebElement etYears=getWebElement(By.id("etYears"));
        etYears.clear();
        etYears.sendKeys(String.valueOf(yearNumber));
        return this;
    }

    public EmiCalculatorScreen fillMonth(int monthNumber){
        General.waitForDomStable();
        WebElement etMonths=getWebElement(By.id("etMonths"));
        etMonths.clear();
        etMonths.sendKeys(String.valueOf(monthNumber));
        return this;
    }

    public EmiCalculatorScreen fillProcessingFee(int fee){
        General.waitForDomStable();
        WebElement etFee=getWebElement(By.id("etFee"));
        etFee.clear();
        etFee.sendKeys(String.valueOf(fee));
        return this;
    }

    public EmiCalculatorScreen tabOnCalculatorBtn(){
        General.waitForDomStable();
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public EmiCalculatorScreen tabOnResetBtn(){
        General.waitForDomStable();
        getWebElement(By.id("btnReset")).click();
        return this;
    }

    public DetailsScreen tabOnDetailBtn(){
        General.waitForDomStable();
        getWebElement(By.id("btnDetail")).click();
        return getInstance(DetailsScreen.class);
    }

    public boolean hasDetailBtn(){
        return getWebElements(By.id("btnDetail")).size()>0;
    }
}
