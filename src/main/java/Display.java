import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Display implements Initializable {
    @FXML
    private Canvas canvas;

    MatrixGrayImage image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.image = MatrixGrayImage.createImageFromPGMFile("images/luminy.pgm");
        // Transform trans = new invert();
        // Transform trans = new DecreaseGrayLevels(4);
        // Transform trans = new Outline(0.0242);
        // Transform trans = new Pixellate(20);

        Transform[] transforms = new Transform[] {
           new DecreaseGrayLevels(4), new Outline(0.242), new invert()//, new Pixellate(20)
        };
        Transform trans = new CompositeTransform(transforms);
        trans.applyTo(image);

        render();
    }

    public void render() {
        int pixelWidth = image.getWidth();
        int pixelHeight = image.getHeight();

        canvas.setWidth(pixelWidth);
        canvas.setHeight(pixelHeight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int i = 0; i < pixelWidth; i++) {
            for (int j = 0; j < pixelHeight; j++) {
                renderPixel(i,j, pixelWriter);
            }
        }
    }

    private void renderPixel(int x, int y, PixelWriter pixelWriter) {
        pixelWriter.setColor(x, y, image.getPixelColor(x, y));
    }

}
