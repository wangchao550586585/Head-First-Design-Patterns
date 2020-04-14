package StructuralPattern.Bridge.image;

public class GIFImage extends Image {
    @Override
    public void parseImage(String fileName) {
        Matrix matrix = new Matrix();
        image.doPaint(matrix);
        System.out.println(fileName+"格式为GIF");
    }
}
