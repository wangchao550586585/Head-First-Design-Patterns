package BehavioralPattern.I_TemplateMethod.b;

import java.util.Arrays;

/**
 * 用模板方法排序
 */
public class Main {
	public static void main(String[] args) {
		Duck ducks[] = { new Duck("1", 1), new Duck("2", 4), new Duck("3", 7),
				new Duck("4", 2) };
		Arrays.sort(ducks);
		System.out.println(Arrays.toString(ducks));
	}
}
