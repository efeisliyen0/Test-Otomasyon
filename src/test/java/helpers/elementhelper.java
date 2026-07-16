package helpers;

import helperimplementation.ElementHelperImplementation;
import org.openqa.selenium.By;

public class elementhelper {

    private static final ElementHelperImplementation implementation = new ElementHelperImplementation();
    public static void click(By locator) {implementation.click(locator);}
    public static void sendKeys(By locator, String text) {implementation.sendKeys(locator, text);}
    public static void clear(By locator) {implementation.clear(locator);}
    public static String getText(By locator) {return implementation.getText(locator);}
    public static boolean isDisplayed(By locator) {return implementation.isDisplayed(locator);}
    public static int getNumber(By locator) {return implementation.getNumber(locator);}}