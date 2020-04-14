package StructuralPattern.Bridge.image;

public abstract class Image {
    protected ImageImpl image;

    public abstract void parseImage(String fileName);

    public void setImage(ImageImpl image) {
        this.image = image;
    }
}
