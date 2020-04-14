package StructuralPattern.M_Proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 *使用动态代理完成保护代理
 *
 */
public class MatchMakingTestDrive {
	
	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.drive();
	}

	private void drive() {
		// 创建对象
		PersonBean personBean = new PersonBeanImpl("张三", "女", "兴趣是上网", 10);
		// 创建拥有者对象
		PersonBean ownerProxy = getOwnerProxy(personBean);
		System.out.println(ownerProxy.getName());
		// 行得通
		ownerProxy.setInterests("bowling go");
		System.out.println(ownerProxy.getInterests());
		// 改变评分，行不通
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("修改评分失败");
		}

		System.out.println("============");
		// 创建非拥有者对象
		PersonBean nonOwnerProxy = getNonOwnerProxy(personBean);
		// 失败
		try {
			nonOwnerProxy.setInterests("哈哈");
		} catch (Exception e) {
			System.out.println("设置兴趣爱好失败");
		}
		// 成功
		nonOwnerProxy.setHotOrNotRating(8);
		System.out.println(nonOwnerProxy.getHotOrNotRating());

	}

	private PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(),
				new NonOwnerInvocationHandler(person));
	}

	public PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(),
				new OwnerInvocationHandler(person));
	}
}
