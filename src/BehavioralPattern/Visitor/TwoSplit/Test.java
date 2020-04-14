package BehavioralPattern.Visitor.TwoSplit;

/**
 * 双分派解决动态绑定
 * 类A中的方法method1和method2的区别就是，method2是双分派。
 * 我们可以看一下java双分派的特点：首先要有一个访问类B，类B提供一个showA(A a) 方法，在方法中，
 * 调用类A的method1方法，然后类A的method2方法中调用类B的showA方法并将自己作为参数传给showA。
 * 双分派的核心就是这个this对象
 *
 * 双分派实现动态绑定的本质，就是在重载方法委派的前面加上了继承体系中覆盖的环节，由于覆盖是动态的，所以重载就是动态的了，
 * 与使用instanceof操作符的效果是一样的（用instanceof操作符可以实现重载方法动态绑定的原因也是因为instanceof操作符是动态的）。
 * 但是与使用instanceof操作符实现动态绑定相比，双分派方式的可扩展性要好的多。
 */
class Father {
    public void accept(Execute exe) {
        exe.method(this);
    }
}

class Son1 extends Father {
    public void accept(Execute exe) {
        exe.method(this);
    }
}

class Son2 extends Father {
    public void accept(Execute exe) {
        exe.method(this);
    }
}
class Execute {
    public void method(Father father) {
        System.out.println("father");
    }

    public void method(Son1 son1) {
        System.out.println("son1");

    }

    public void method(Son2 son2) {
        System.out.println("son2");

    }
}

public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Father son1 = new Son1();
        Father son2 = new Son2();

        Execute execute = new Execute();
        father.accept(execute);
        son1.accept(execute);
        son2.accept(execute);
    }
}
