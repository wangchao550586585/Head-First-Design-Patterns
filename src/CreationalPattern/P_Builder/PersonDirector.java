package CreationalPattern.P_Builder;

public class PersonDirector {
    public Person build(PersonBuilder pb) {
        pb.buildBody();
        pb.buildFoot();
        pb.buildHead();
        return pb.buildPerson();
    }
}
