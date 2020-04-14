package StructuralPattern.N_Composite.duck.composite_iterator;

import java.util.ArrayList;
import java.util.Iterator;

import StructuralPattern.N_Composite.duck.Quackable;
import StructuralPattern.N_Composite.duck.observer.Observer;

/**
 * 组合模式和迭代器模式 透明性：因为组合(菜单)和叶节点(菜单项)具有一组相同的方法，好处是2者之间是透明的，客户不需要管是叶节点还是组合.
 * 2者调用的同一个方法 但是因为因为这样失去了安全性 安全：叶节点和组合分开即可，
 * 组合不继承Quackable，但是调用add时需要确定参数是Flock对象，这样也损失了透明性
 */
public class Flock implements Quackable {

	ArrayList<Quackable> quarkers = new ArrayList<Quackable>();

	public void add(Quackable quarker) {
		this.quarkers.add(quarker);
	}

	@Override
	public void quack() {
		Iterator<Quackable> iterator = quarkers.iterator();
		while (iterator.hasNext()) {
			Quackable next = iterator.next();
			next.quack();
		}
	}
	//当响flock注册观察者时，其实是向所有Quackable注册
	public void registerObserver(Observer observer) {
		Iterator<Quackable> iterator = quarkers.iterator();
		while (iterator.hasNext()) {
			Quackable next = iterator.next();
			next.registerObserver(observer);
		}
	}

	//每个Quackable负责自己通知观察者，不需要flock负责
	public void notifyObservers() {
	}

}
