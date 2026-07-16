package helperimplementation;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionHelperImplementation {

    public void assertEquals(String actual, String expected) {
        assertThat(actual)
                .isEqualTo(expected);
    }

    public void assertEquals(int actual, int expected) {
        assertThat(actual)
                .isEqualTo(expected);
    }

    public void assertTrue(boolean condition) {
        assertThat(condition)
                .isTrue();
    }

    public void assertFalse(boolean condition) {
        assertThat(condition)
                .isFalse();
    }
}