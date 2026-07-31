package helpers;

import exceptions.TestDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestDataReader;

public class TestDataHelper {

    private static final Logger logger = LogManager.getLogger(TestDataHelper.class);

    public static String getTestData(String value) {
        try {
            if (value != null && value.contains(".")) {
                String[] parts = value.split("\\.");
                return TestDataReader.getValue(parts[0], parts[1]);
            }
            return value;
        } catch (Exception e) {
            logger.error("Test data read failed: {}", value, e);
            throw new TestDataException("Test data could not be read: " + value, e
            );
        }
    }
}