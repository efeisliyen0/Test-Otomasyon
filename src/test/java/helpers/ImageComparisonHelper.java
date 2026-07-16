package helpers;

import helperimplementation.ImageComparisonHelperImplementation;

public class ImageComparisonHelper {

    private static final ImageComparisonHelperImplementation implementation =
            new ImageComparisonHelperImplementation();

    public static void compare(String fileName) {
        implementation.compare(fileName);
    }
}