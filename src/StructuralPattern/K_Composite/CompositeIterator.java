package StructuralPattern.K_Composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * 组合迭代器
 * 外部迭代器，所以需要维护组合递归结构的位置，采用栈维护
 */
public class CompositeIterator implements Iterator {
	Stack<Iterator> stack = new Stack<Iterator>();

	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}

	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator peek = stack.peek();
			if (!peek.hasNext()) {
				stack.pop();
				return hasNext();
			} else
				return true;
		}
	}

	public Object next() {
		if (hasNext()) {
			Iterator peek = stack.peek();
			MenuComponent next = (MenuComponent) peek.next();
			if (next instanceof Menu) {
				stack.push(next.createIterator());
			}
			return next;
		}
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
