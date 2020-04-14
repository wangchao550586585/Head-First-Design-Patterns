package StructuralPattern.G_Adapter.a;

public class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("gobble");

	}

	@Override
	public void fly() {
		System.out.println("fly");
	}

}
