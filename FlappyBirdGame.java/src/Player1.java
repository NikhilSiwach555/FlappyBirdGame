import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.awt.image.RasterFormatException;

public class Player1 {
    BufferedImage[] birdImages = new BufferedImage[3];
    BufferedImage completeImage;
    BufferedImage backgroundImage;

    public Player1() {
        try {
            completeImage = ImageIO.read(getClass().getResource("/flappybirdss.png"));
            loadBirdImages();
        } catch (IOException e) {
            System.err.println("image not loaded");
            e.printStackTrace();
        }
    }

    private void loadBirdImages() {
        try {
            BufferedImage birdImage1 = completeImage.getSubimage(87, 491, 17, 12);
            BufferedImage birdImage2 = completeImage.getSubimage(115, 355, 17, 12);
            BufferedImage birdImage3 = birdImage2;
            backgroundImage = completeImage.getSubimage(0, 0, 144, 255);

            birdImages[0] = birdImage1;
            birdImages[1] = birdImage2;
            birdImages[2] = birdImage3;
        } catch (RasterFormatException e) {
            System.err.println("image not loaded");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("image not loaded");
            e.printStackTrace();
        }
    }

    public BufferedImage[] getBirdImage() {
        return birdImages;
    }

    public int getBirdHeight() {
        return birdImages[0].getHeight();
    }

    public int getBirdWidth() {
        return birdImages[0].getWidth();
    }

    public void paintImage(Graphics pen, BufferedImage birdImage, int x, int y) {
        pen.drawImage(backgroundImage, 0, 0, 600, 700, null);
        pen.drawImage(birdImage, x, y, 25, 25, null);
    }
}
