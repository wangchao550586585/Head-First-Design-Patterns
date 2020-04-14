package StructuralPattern.Flyweight.IgoChessman;

import java.util.Hashtable;

class  Coordinates{
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
//围棋棋子类：抽象享元类
abstract class IgoChessman {
    public abstract String getColor();

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }

    //增加棋子棋子坐标,带外部状态的解决方案
    public void display(Coordinates coordinates){
        System.out.println("棋子颜色:"+this.getColor()+"棋子坐标"+coordinates.getX()+":"+coordinates.getY());
    }
}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman {

    @Override
    public String getColor() {
        return "黑色";
    }
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman {

    @Override
    public String getColor() {
        return "白色";
    }
}

//围棋棋子工厂类：享元工厂类，使用单例模式进行设计
class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable<String, IgoChessman> ht;//使用table存储享元对象,充当享元池

    private IgoChessmanFactory() {
        ht = new Hashtable();
        ht.put("b", new BlackIgoChessman());
        ht.put("w", new WhiteIgoChessman());
    }

    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    public IgoChessman getIgoChessman(String color) {
        return ht.get(color);
    }
}

public class Test {
    public static void main(String[] args) {
        IgoChessmanFactory instance = IgoChessmanFactory.getInstance();
        IgoChessman b = instance.getIgoChessman("b");
        IgoChessman b1 = instance.getIgoChessman("b");
        IgoChessman b2 = instance.getIgoChessman("b");

        b.display();
        b1.display();
        b2.display();


        IgoChessman w = instance.getIgoChessman("w");
        IgoChessman w1 = instance.getIgoChessman("w");

        w.display();
        w1.display();

        //增加外部状态
        b.display(new Coordinates(1,2));
        b1.display(new Coordinates(3,4));
        b2.display(new Coordinates(1,3));
        w.display(new Coordinates(2,5));
        w1.display(new Coordinates(2,4));

    }
}