package helpers;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionHelper {

    public static void assertEquals(String actual, String expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertEquals(int actual, int expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertTrue(boolean condition) {
        assertThat(condition).isTrue();
    }

    public static void assertFalse(boolean condition) {
        assertThat(condition).isFalse();
    }
}