package BehavioralPattern.Visitor.staticBind;

/**
 * 相对于动态绑定，静态绑定就是指在编译期就已经确定执行哪一个方法。在java中，方法的重载（方法名相同而参数不同）就是静态绑定的，重载时，执行哪一个方法在编译期就已经确定下来了。看一下代码：
 */
class Father {

}

class Son1 extends Father {
}

class Son2 extends Father {
}

class Execute {
    public void method(Father father) {
        //System.out.println("father");

        //手动设置动态
        if (father instanceof Son1) {
            method((Son1) father);
        } else if (father instanceof Son2) {
            method((Son2) father);
        } else if (father instanceof Father) {
            System.out.println("father");
        }
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
        execute.method(father);
        execute.method(son1);
        execute.method(son2);
        }
}