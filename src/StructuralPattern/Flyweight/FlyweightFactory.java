package StructuralPattern.Flyweight;

import java.util.Hashtable;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new Hashtable<>();

    public Flyweight get(String key) {
        Flyweight flyweight = this.flyweights.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }

    public int size() {
        return flyweights.size();
    }
}
