package StepImplementation;

import helpers.AssertionHelper;
import helpers.elementhelper;
import locators.LocatorManager;

public class VerifyImp {

    public void verifyText(String locatorName, String expectedText) {

        String actualText = elementhelper.getText(
                LocatorManager.getLocator(locatorName)
        );

        AssertionHelper.assertEquals(actualText, expectedText);
    }

    public void verifyDisplayed(String locatorName) {

        boolean displayed = elementhelper.isDisplayed(
                LocatorManager.getLocator(locatorName)
        );

        AssertionHelper.assertTrue(displayed);
    }

    public void verifyNumber(String locatorName, int expectedNumber) {

        int actualNumber = elementhelper.getNumber(
                LocatorManager.getLocator(locatorName)
        );

        AssertionHelper.assertEquals(actualNumber, expectedNumber);
    }

    public void verifyNotDisplayed(String locatorName){}

}