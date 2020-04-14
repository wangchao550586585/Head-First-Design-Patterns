package StructuralPattern.Flyweight;

public class ConcreteFlyweight extends Flyweight {
    private String str;

    public ConcreteFlyweight(String str) {
        this.str = str;
    }

    @Override
    public void operation() {
        System.out.println(str);
    }
}
