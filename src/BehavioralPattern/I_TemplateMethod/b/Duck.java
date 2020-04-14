package BehavioralPattern.I_TemplateMethod.b;

public class Duck implements Comparable<Duck> {
	String name;
	int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + "]";
	}

	public int compareTo(Duck o) {
		return this.weight - o.weight;
	}
}
