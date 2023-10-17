package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.Screens.CompareLoanScreen;
import com.emiCalculator.pom.Screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoanTest extends BaseTest {
    CompareLoanScreen compareLoanScreen;

//    public int amount=100000;
    @Test(priority = 0)
    public void compareLoanShouldSucceed() {
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasCompareLoanBtn());

        compareLoanScreen = homeScreen
                .tabOnCompareLoanBtn();

                compareLoanScreen = compareLoanScreen
                .fillLoan1Amount(Integer.parseInt(getCompareLone1()))
                .fillInterest1(Integer.parseInt(getCompareInterest1()))
                .fillMonth1(Integer.parseInt(getCompareMonth1()))
                .fillLoan2Amount(Integer.parseInt(getCompareLone2()))
                .fillInterest2(Integer.parseInt(getCompareInterest2()))
                .fillMonth2(Integer.parseInt(getCompareMonth2()))
                .tapCalculatorBtn();
        Assert.assertTrue(compareLoanScreen.hasResultLayout());
    }

    @Test(priority = 1)
    public void checkCompareScreenTextAmountShouldSucceed() {
        String emiText=compareLoanScreen.getEmiText();
        System.out.println("checkDetailScreenNameShouldSucceed: "+emiText);
        Assert.assertEquals("EMI",emiText);
    }

    @Test(priority = 2)
    public void checkCompareScreenAmountShouldSucceed() {
        Assert.assertTrue(compareLoanScreen.hasCalculatorBtn());
    }

    @Test(priority = 3)
    public void checkCompareScreenValueShouldSucceed() {
        Assert.assertTrue(compareLoanScreen.hasCalculatorBtn());
    }

    @Test(priority = 4)
    public void checkCompareScreenDiffOneShouldSucceed() {
        Assert.assertTrue(compareLoanScreen.hasCalculatorBtn());
    }

    @Test(priority = 5)
    public void resetCompareLoansShouldSucceed() {
        compareLoanScreen = compareLoanScreen
                .tapResetBtn();
        Assert.assertTrue(compareLoanScreen.hasCalculatorBtn());
    }
}
