package helpers;

import utils.TestDataReader;

public class TestDataHelper {

    public static String getTestData(String value) {
        if (value.contains(".")) {
            String[] parts = value.split("\\.");
            return TestDataReader.getValue(parts[0], parts[1]);
        }
        return value;
    }
}
