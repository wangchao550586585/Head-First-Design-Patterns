package CreationalPattern.Prototype;

import java.util.ArrayList;
import java.util.Arrays;

public class Prototype implements Cloneable {
    public Prototype clone() {
        Prototype clone = null;
        try {
            clone = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
