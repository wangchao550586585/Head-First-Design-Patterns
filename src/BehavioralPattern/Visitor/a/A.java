package BehavioralPattern.Visitor.a;


public class A {
    public void method(){
        System.out.println("我是A");
    }
    public void method(B b){
        b.showA(this);
    }
}
