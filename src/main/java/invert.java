public class invert implements Transform {
    public void applyTo(GrayImage image) {
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                GrayColor inverted = image.getPixelGrayColor(x, y).invert();
                image.setPixel(inverted, x, y);
            }
        }
    }
}

