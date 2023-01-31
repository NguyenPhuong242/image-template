public class Outline implements Transform {
    private final double threshold;

    public Outline(double threshold){
        this.threshold = threshold;
    }

    @Override
    public void applyTo(GrayImage image) {
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                GrayColor pixel = image.getPixelGrayColor(x, y);
                GrayColor color1 = x == image.getWidth() - 1 ? pixel: image.getPixelGrayColor(x+1, y);
                GrayColor color2 = y == image.getHeight() - 1 ? pixel: image.getPixelGrayColor(x, y+1);
                GrayColor color = isDifferentFrom(pixel, color1) || isDifferentFrom(pixel, color2) ? ByteGrayColor.Noir:ByteGrayColor.Blanc;
                image.setPixel(color, x, y);
            }
        }
    }
    private boolean isDifferentFrom(GrayColor color1, GrayColor color2){
        return Math.abs(color1.getLuminosity() - color2.getLuminosity()) 
        > threshold;
    }
}

