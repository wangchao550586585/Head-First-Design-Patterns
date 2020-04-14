package StructuralPattern.Bridge.image;

public class Test {
    public static void main(String[] args) {
        Image jpgImage = new JPGImage();
        ImageImpl linux = new LinuxImpl();

        jpgImage.setImage(linux);
        jpgImage.parseImage("图片");
    }
}
