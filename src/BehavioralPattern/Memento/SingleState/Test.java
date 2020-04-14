package BehavioralPattern.Memento.SingleState;


/**
 * 单状态单备份
 *
 * 备忘录模式
 * 定义：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样就可以将该对象恢复到原先保存的状态
 * <p>
 * 备忘录模式的结构
 * 发起人：记录当前时刻的内部状态，负责定义哪些属于备份范围的状态，负责创建和恢复备忘录数据。
 * 备忘录：负责存储发起人对象的内部状态，在需要的时候提供发起人需要的内部状态。
 * 管理角色：对备忘录进行管理，保存和提供备忘录。
 *
 * 备忘录模式的优缺点和适用场景
 备忘录模式的优点有：
 当发起人角色中的状态改变时，有可能这是个错误的改变，我们使用备忘录模式就可以把这个错误的改变还原。
 备份的状态是保存在发起人角色之外的，这样，发起人角色就不需要对各个备份的状态进行管理。
 备忘录模式的缺点：
 在实际应用中，备忘录模式都是多状态和多备份的，发起人角色的状态需要存储到备忘录对象中，对资源的消耗是比较严重的。
 */
class Memento {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento(String state) {
        this.state = state;
    }
}

class Originator {
    private String state;

    public Memento createMemento() {
        return new Memento(getState());
    }

    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("开启");
        System.out.println(originator.getState());

        //备忘
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("关闭");
        System.out.println(originator.getState());

        //恢复
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
