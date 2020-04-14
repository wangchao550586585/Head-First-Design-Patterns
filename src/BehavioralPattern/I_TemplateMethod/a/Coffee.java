package BehavioralPattern.I_TemplateMethod.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends CaffeineBeverage {

	public void addCondiments() {
		System.out.println("加糖和牛奶");
	}

	public void brew() {
		System.out.println("用沸水冲泡咖啡");
	}

	public boolean customerWantsCondiments() {
		// 这里模拟用户不需要添加调料
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y"))
			return true;
		else
			return false;
	}

	private String getUserInput() {
		String answer = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answer == null ? "no" : answer;
	}
}