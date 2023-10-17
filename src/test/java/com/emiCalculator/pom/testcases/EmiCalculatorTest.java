package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.Screens.DetailsScreen;
import com.emiCalculator.pom.Screens.EmiCalculatorScreen;
import com.emiCalculator.pom.Screens.HomeScreen;
import com.emiCalculator.pom.util.General;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseTest {
    EmiCalculatorScreen emiCalculatorScreen;
    DetailsScreen detailScreen;

//    public int amount=100000;


    @Test(priority = 0)
    public void calculatorEmiShouldSucceed() {
        emiCalculatorScreen = screen.getInstance(HomeScreen.class)
                .tabOnEmiCalculatorBtn();

        emiCalculatorScreen = emiCalculatorScreen
                .fillAmount(Integer.parseInt(getEmiAmount()))
                .fillInterest(Integer.parseInt(getEmiInterest()))
                .fillYear(Integer.parseInt(getEmiYear()))
                .fillMonth(Integer.parseInt(getEmiMonth()))
                .fillProcessingFee(Integer.parseInt(getEmiFee()))
                .tabOnCalculatorBtn();
        General.waitForDomStable();
        Assert.assertTrue(emiCalculatorScreen.hasDetailBtn());
    }

    @Test(priority = 1)
    public void resetShouldSucceed() {
        emiCalculatorScreen = emiCalculatorScreen
                .fillAmount(Integer.parseInt(getEmiAmount()))
                .fillInterest(Integer.parseInt(getEmiInterest()))
                .fillYear(Integer.parseInt(getEmiYear()))
                .fillMonth(Integer.parseInt(getEmiMonth()))
                .fillProcessingFee(Integer.parseInt(getEmiFee()))
                .tabOnResetBtn();
    }

    @Test(priority = 2)
    public void checkDetailShouldSucceed() {
        emiCalculatorScreen = emiCalculatorScreen
                .fillAmount(Integer.parseInt(getEmiAmount()))
                .fillInterest(Integer.parseInt(getEmiInterest()))
                .fillYear(Integer.parseInt(getEmiYear()))
                .fillMonth(Integer.parseInt(getEmiMonth()))
                .fillProcessingFee(Integer.parseInt(getEmiFee()))
                .tabOnCalculatorBtn();

        detailScreen = emiCalculatorScreen
                .tabOnDetailBtn();
        Assert.assertTrue(detailScreen.hasDetailsLayout());
    }

    @Test(priority = 3)
    public void checkDetailScreenAmountShouldSucceed() {
        Assert.assertEquals(Integer.parseInt(getEmiAmount()),detailScreen.getLoanAmount());
    }

    @Test(priority = 4)
    public void checkDetailScreenTextAmountShouldSucceed() {
        String amountText=detailScreen.getTextAmount();
//        System.out.println("checkDetailScreenNameShouldSucceed: "+amountText);
        Assert.assertEquals("Amount",amountText);
    }

    @Test(priority = 5)
    public void checkBackBtnShouldSucceed() {
        emiCalculatorScreen=detailScreen
                .getBackBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailBtn());
    }
}
