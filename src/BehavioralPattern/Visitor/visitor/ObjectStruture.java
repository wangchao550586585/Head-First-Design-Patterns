package BehavioralPattern.Visitor.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStruture {

    public static List<Element> list() {
        List<Element> list = new ArrayList<>();
        list.add(new ConcreteElement1());
        list.add(new ConcreteElement2());
        return list;
    }
}
