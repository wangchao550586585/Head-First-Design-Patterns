package StructuralPattern.K_Composite;

/**
 * 组合模式：允许你将对象组合成树形结构来表现"整体/部分"层次结构。组合能让客户以一致的方式处理个别对象以及对象组合
 * 尽管组合内的对象行为不一样，但是为了保持透明性，以及让用户不操心那个对象用那个接口，需要实现同一接口
 * 用不同的接口组合，也算组合模式(更加安全的组合模式)
 */
public class Main {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("煎饼菜单", "早餐");
		MenuComponent dinermenu = new Menu("早餐", "早餐");
		MenuComponent cafeMenu = new Menu("午餐", "午餐");
		MenuComponent dessertMenu = new Menu("甜点", "甜点");

		MenuComponent allMenu = new Menu("所有菜单", "all menu");
		allMenu.add(pancakeHouseMenu);
		allMenu.add(dinermenu);
		allMenu.add(cafeMenu);

		dinermenu.add(new MenuItem("拉面", "拉面", true, 10));
		dinermenu.add(dessertMenu);

		dessertMenu.add(new MenuItem("南瓜饼", "南瓜饼", false, 10));

		Waitress waitress = new Waitress(allMenu);
		waitress.printMenu();
	}
}
