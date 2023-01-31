public class DecreaseGrayLevels implements Transform {
    
    public final int nbGrayLevels;

    public DecreaseGrayLevels(int nbGrayLevels){
        this.nbGrayLevels = nbGrayLevels;
    }

    @Override
    public void applyTo(GrayImage image){
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                GrayColor oldColor = image.getPixelGrayColor(x, y);
                double newLuminosity = (double) Math.round(oldColor.getLuminosity() * (nbGrayLevels - 1)) / (nbGrayLevels - 1);
                GrayColor decrease = new ByteGrayColor(newLuminosity);
                image.setPixel(decrease, x, y);
            }
        }
    }
}   

