package CreationalPattern.D_Factory.c_FactoryMethod;

public abstract class Pizza {
	public String name;
	public Dough dough;
	public String sauce;
	public String cheese;
	public String clam;

	public void prepare() {
		System.out.println("prepare");
	}

	public void bake() {
		System.out.println("bake");
	}

	public void cut() {
		System.out.println("cut");
	}

	public void box() {
		System.out.println("box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
