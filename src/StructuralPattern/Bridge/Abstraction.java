package StructuralPattern.Bridge;

public abstract class Abstraction {
    protected Implementor implementor;

    public abstract void operation();

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
}
