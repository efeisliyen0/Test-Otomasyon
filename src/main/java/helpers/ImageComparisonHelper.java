package helpers;

import exceptions.ImageComparisonException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class ImageComparisonHelper {

    private static final Logger logger = LogManager.getLogger(ImageComparisonHelper.class);

    public static void compare(String fileName) {
        try {
            File baselineFile = new File(".gauge/screenshots/visual/baseline/" + fileName + ".png");
            File actualFile = new File(".gauge/screenshots/visual/actual/" + fileName + ".png");
            BufferedImage baselineImage = ImageIO.read(baselineFile);
            BufferedImage actualImage = ImageIO.read(actualFile);
            boolean result = compareImages(baselineImage, actualImage);
            assertThat(result).as("Screenshots are different!").isTrue();
        } catch (Exception e) {
            logger.error("Image comparison failed: {}", fileName, e);
            throw new ImageComparisonException("Image comparison failed: " + fileName, e);
        }
    }
    private static boolean compareImages(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {return false;}
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {return false;}
            }
        }
        return true;
    }
}