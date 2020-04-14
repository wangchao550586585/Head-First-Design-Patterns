package StructuralPattern.Bridge.image;

/**
 * 抽象操作系统实现类：实现类接口
 */
public interface ImageImpl {
    /**
     * 显示像素矩阵
     * @param matrix
     */
    void doPaint(Matrix matrix);
}
