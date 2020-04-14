package BehavioralPattern.Memento.MultiStatus;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class Originator {
    private String state1;
    private String state2;
    private String state3;

    public Memento create() {
        return new Memento(BeanUtils.backupProp(this));
    }

    public void restore(Memento memento) {
        BeanUtils.restore(this, memento.getStateMap());
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getState3() {
        return state3;
    }

    public void setState3(String state3) {
        this.state3 = state3;
    }

    @Override
    public String toString() {
        return "Originator{" +
                "state1='" + state1 + '\'' +
                ", state2='" + state2 + '\'' +
                ", state3='" + state3 + '\'' +
                '}';
    }
}

class Memento {
    private Map<String, Object> stateMap;

    public Memento(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}

class Caretaker {
    private Map<String, Memento> mementoMap = new HashMap<>();

    public Memento getMementoMap(String index) {
        return mementoMap.get(index);
    }

    public void setMementoMap(String index, Memento memento) {
        mementoMap.put(index, memento);
    }
}

class BeanUtils {

    public static Map<String, Object> backupProp(Object bean) {
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                Method readMethod = propertyDescriptor.getReadMethod();
                Object fieldValue = readMethod.invoke(bean);
                result.put(name, fieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void restore(Object bean, Map<String, Object> propMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (propMap.containsKey(name)) {
                    propertyDescriptor.getWriteMethod().invoke(bean, new Object[]{propMap.get(name)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState1("开启");
        originator.setState2("故障");
        originator.setState3("重启");
        System.out.println(originator.toString());

        Caretaker caretaker = new Caretaker();
        caretaker.setMementoMap("state1", originator.create());

        originator.setState1("重启");
        originator.setState2("故障");
        originator.setState3("开启");
        System.out.println(originator.toString());

        originator.restore(caretaker.getMementoMap("state1"));
        System.out.println(originator.toString());
    }
}
