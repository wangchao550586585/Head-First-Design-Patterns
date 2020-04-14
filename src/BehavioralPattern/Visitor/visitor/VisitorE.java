package BehavioralPattern.Visitor.visitor;

public class VisitorE implements Visitor {
    @Override
    public void visit(ConcreteElement1 e) {
        e.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 e) {
        e.doSomething();
    }
}
