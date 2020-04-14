package CreationalPattern.P_Builder;




public class ManBuilder implements PersonBuilder {
    Person person;

    public ManBuilder() {
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("建造男人头");
    }

    @Override
    public void buildBody() {
        person.setBody("建造男人身体");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造男人脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }

}
