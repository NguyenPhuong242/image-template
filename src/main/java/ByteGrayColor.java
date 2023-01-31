import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */

public class ByteGrayColor implements GrayColor {

    private static final int MINIMUM_GRAY_LEVEL = 0;
    private static final int MAXIMUM_GRAY_LEVEL = 255;
    private static final int OPACITY = 1;

    public final static ByteGrayColor Blanc = new ByteGrayColor(MAXIMUM_GRAY_LEVEL);
    public final static ByteGrayColor Noir = new ByteGrayColor(MINIMUM_GRAY_LEVEL);

    private final int grayLevel;

    public ByteGrayColor(){
       this.grayLevel = MINIMUM_GRAY_LEVEL;
    }

    public ByteGrayColor(int grayLevel) {
        if(grayLevel < MINIMUM_GRAY_LEVEL)
            this.grayLevel = MINIMUM_GRAY_LEVEL;
        else if(grayLevel > MAXIMUM_GRAY_LEVEL)
            this.grayLevel = MAXIMUM_GRAY_LEVEL;
        else
            this.grayLevel = grayLevel;
    }


    public ByteGrayColor(double luminosity) {
        this.grayLevel = (int) (luminosity * MAXIMUM_GRAY_LEVEL);
    }

    @Override
    public double getLuminosity() {
        return (double) this.grayLevel / MAXIMUM_GRAY_LEVEL;
    }

    @Override
    public Color getColor(){
        double component = getLuminosity();
        return new Color(component, component, component, OPACITY);
    }


    @Override
    public int compareTo(GrayColor o) {
        ByteGrayColor i = (ByteGrayColor) o;
        if(this.getLuminosity() == i.getLuminosity()){
            return 0;
        }
        else if(this.getLuminosity() > i.getLuminosity()){
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        ByteGrayColor color = (ByteGrayColor) o;
        return grayLevel == color.grayLevel;
    }

    public GrayColor invert() {
        return new ByteGrayColor(MAXIMUM_GRAY_LEVEL - this.grayLevel);
        
    }
}
