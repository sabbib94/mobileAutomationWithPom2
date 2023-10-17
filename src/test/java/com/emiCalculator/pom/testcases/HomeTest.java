package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.Screens.HomeScreen;
import com.emiCalculator.pom.util.EmiString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
//    @Test
//    public void verifyEmiScreenTitle(){
//        HomeScreen homeScreen=screen.getInstance(HomeScreen.class);
//        Assert.assertEquals(homeScreen.getEmiCalculotorPageTitle(),EmiString.LOGIN_TITLE);
//    }

    @Test(enabled = true)
    public void checkEmiCalculatorBtnShouldSucceed(){
        HomeScreen homeScreen=screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasEmiCalculatorBtn());
    }

    @Test(enabled = true)
    public void checkCompareLoanBtnShouldSucceed(){
        HomeScreen homeScreen=screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasCompareLoanBtn());
    }
}
