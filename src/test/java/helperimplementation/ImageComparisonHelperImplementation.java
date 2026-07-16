package helpers;

import org.testng.Assert; // JUnit ise org.junit.Assert
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComparisonHelperImplementation implements ImageComparisonHelper {

    @Override
    public void compareImages(String imageName) {
        try {
            File baselineFile = new File("screenshots/baseline/" + imageName + ".png");
            File actualFile = new File("screenshots/actual/" + imageName + ".png");

            BufferedImage baselineImage = ImageIO.read(baselineFile);
            BufferedImage actualImage = ImageIO.read(actualFile);

            boolean isIdentical = comparePixels(baselineImage, actualImage);
            Assert.assertTrue(isIdentical, imageName + " görseli baseline ile eşleşmiyor! Arayüzde farklılık var.");

        } catch (IOException e) {
            Assert.fail("Görseller okunamadı. Dosya yollarını kontrol et: " + e.getMessage());
        }
    }

    // Java AWT ile temel piksel karşılaştırması
    private boolean comparePixels(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false; // Boyutlar farklıysa zaten eşleşmez
        }
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false; // Farklı bir piksel bulundu
                }
            }
        }
        return true;
    }
}
