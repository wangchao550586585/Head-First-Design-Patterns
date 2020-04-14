package BehavioralPattern.Visitor.a;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.method();
        a.method(new B());
    }
}
