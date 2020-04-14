package StructuralPattern.Bridge;

public class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        implementor.operationImpl();
    }
}
