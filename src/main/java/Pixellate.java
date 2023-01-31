public class Pixellate implements Transform {

    private final int newPixelSize;

    public Pixellate(int newPixelSize){
        this.newPixelSize = newPixelSize;
    }

    @Override
    public void applyTo(GrayImage image){
        for(int x = 0; x < image.getWidth(); x = x + newPixelSize){
            for(int y = 0; y <image.getHeight(); y = y  +newPixelSize){
                GrayColor average = getAverage(image, x , y);
                fillNewPixel(image, average, x, y);
            }
        }
    }

    private GrayColor getAverage(GrayImage image, int x, int y){
        double Somme = 0;
        int maxX = Math.min(newPixelSize, image.getWidth() - x);
        int maxY = Math.min(newPixelSize, image.getHeight() - y);
        for(int a = 0; a < maxX; a++){
            for(int b = 0; b < maxY; b++ ){
                Somme += image.getPixelGrayColor(x + a, y + b).getLuminosity();
            }
        }
        return new ByteGrayColor(Somme / (maxX * maxY));
    }

    private void fillNewPixel(GrayImage image, GrayColor color, int x, int y){
        int maxX = Math.min(newPixelSize, image.getWidth() -x);
        int maxY = Math.min(newPixelSize, image.getHeight() -y);
        for(int a = 0; a < maxX; a++){
            for(int b = 0; b < maxY; b++ ){
                image.setPixel(color, x+a, y+b);
            }
        }
    }
    
}
