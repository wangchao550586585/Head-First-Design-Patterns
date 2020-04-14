package BehavioralPattern.Mediator.B;


public class Mediator extends AbstractMediator {

    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    @Override
    public void AaffectB() {
        B.setNumber(A.getNumber() * 100);

    }

    @Override
    public void BaffectA() {
        A.setNumber(B.getNumber() / 100);
    }
}
