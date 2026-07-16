package helpers;

import helperimplementation.AssertionHelperImplementation;

public class AssertionHelper {

    private static final AssertionHelperImplementation implementation =
            new AssertionHelperImplementation();

    public static void assertEquals(String actual, String expected) {
        implementation.assertEquals(actual, expected);
    }

    public static void assertEquals(int actual, int expected) {
        implementation.assertEquals(actual, expected);
    }

    public static void assertTrue(boolean condition) {
        implementation.assertTrue(condition);
    }

    public static void assertFalse(boolean condition) {
        implementation.assertFalse(condition);
    }
}