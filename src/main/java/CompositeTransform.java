public class CompositeTransform implements Transform {

    private final Transform[] transforms;

    public CompositeTransform(Transform[] transforms){
        this.transforms = transforms;
    }

    @Override
    public void applyTo(GrayImage image){
        for(Transform transform: transforms){
            transform.applyTo(image);
        }
    }
}
