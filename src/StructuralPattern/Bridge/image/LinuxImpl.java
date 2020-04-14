package StructuralPattern.Bridge.image;

public class LinuxImpl implements ImageImpl {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("在linux显示图像");
    }
}
