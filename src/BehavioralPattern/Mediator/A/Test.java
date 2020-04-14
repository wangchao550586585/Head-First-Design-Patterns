package BehavioralPattern.Mediator.A;

/**
 * 没有中介者模式的样子
 */
public class Test {
    public static void main(String[] args) {
        ColleagueA colleagueA = new ColleagueA();
        ColleagueB colleagueB = new ColleagueB();

        colleagueA.setNumber(100, colleagueB);
        System.out.println(colleagueA.getNumber());
        System.out.println(colleagueB.getNumber());

        colleagueB.setNumber(100, colleagueA);
        System.out.println(colleagueA.getNumber());
        System.out.println(colleagueB.getNumber());
    }
}
