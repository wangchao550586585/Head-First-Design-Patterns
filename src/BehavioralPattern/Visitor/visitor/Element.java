package BehavioralPattern.Visitor.visitor;

public interface Element {
    void accept(Visitor visitor);

    void doSomething();
}
