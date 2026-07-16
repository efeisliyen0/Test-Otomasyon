package StepImplementation;

import helpers.ImageComparisonHelper;
import helpers.ImageComparisonHelperImplementation;

public class CompareImp {
    private ImageComparisonHelper comparisonHelper;

    public CompareImp() {
        this.comparisonHelper = new ImageComparisonHelperImplementation();
    }

    public void doComparison(String imageName) {
        comparisonHelper.compareImages(imageName);
    }
}