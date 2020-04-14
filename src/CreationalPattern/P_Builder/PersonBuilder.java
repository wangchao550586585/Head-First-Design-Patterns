package CreationalPattern.P_Builder;

public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();
}