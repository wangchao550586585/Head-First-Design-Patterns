package BehavioralPattern.Visitor.dynamicBind;

/**
 * 所谓的动态绑定就是指程执行期间（而不是在编译期间）判断所引用对象的实际类型，根据其实际的类型调用其相应的方法。java继承体系中的覆盖就是动态绑定的，
 */
class Father {
    public void method() {
        System.out.println("method");
    }
}

class Son1 extends Father {
    public void method() {
        System.out.println("Son1");
    }
}

class Son2 extends Father {
    public void method() {
        System.out.println("Son2");
    }
}
public class Test {
    public static void main(String[] args) {
        Father son1 = new Son1();
        son1.method();
        Father son2 = new Son2();
        son2.method();
    }
}

