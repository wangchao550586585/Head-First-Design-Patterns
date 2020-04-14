package BehavioralPattern.Mediator.A;

public class ColleagueB extends AbstractColleague {
    @Override
    public void setNumber(int number, AbstractColleague colleague) {
        this.number = number;
        colleague.setNumber(number / 100);
    }
}