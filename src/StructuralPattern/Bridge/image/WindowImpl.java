package StructuralPattern.Bridge.image;

public class WindowImpl implements ImageImpl {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("在window显示图像");
    }
}
