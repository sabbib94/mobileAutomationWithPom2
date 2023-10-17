package com.emiCalculator.pom.Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DetailsScreen extends BaseScreen{
    public DetailsScreen(AndroidDriver driver) {
        super(driver);
    }
    public boolean hasDetailsLayout(){
        return getWebElements(By.className("android.widget.TextView")).size()>0;
    }

    public String getTextAmount(){
        String amountText=getWebElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView")).getText();
        return amountText;
    }

    public int getLoanAmount(){
        String amount=getWebElement(By.id("loan_amount_result")).getText().trim().replaceAll(",","");
        return Integer.parseInt(amount);
    }

    public EmiCalculatorScreen getBackBtn(){
        getWebElement(By.id("actionMenuBack")).click();
        return getInstance(EmiCalculatorScreen.class);
    }
}
