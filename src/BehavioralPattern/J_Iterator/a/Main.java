package BehavioralPattern.J_Iterator.a;

/**
 *迭代器模式：提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示
 *统一方法访问聚合每一个对象，不需要管菜单项究竟是集合还是数组
 *元素之间游走任务交给迭代器，这样可以让集合更关注它所关注的上面(管理对象)，而不是遍历等
 *内部迭代器：自己控制(因为迭代器自行在元素之间游走，所以必须告诉迭代器在游走过程中要干嘛，也就是必须将操作传给迭代器)
 *外部迭代器：客户通过next()获取下个元素
 *单一责任：一个类应该只有一个引起变化的原因(内聚)
 */
public class Main {
	public static void main(String[] args) {
		DinerMenu dinerMenu = new DinerMenu();
		PancakeHouseMenu houseMenu = new PancakeHouseMenu();
		Waitress waitress = new Waitress(houseMenu, dinerMenu);
		waitress.printMent();
	}
}
