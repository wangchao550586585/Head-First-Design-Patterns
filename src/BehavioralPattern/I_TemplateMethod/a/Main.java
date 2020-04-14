package BehavioralPattern.I_TemplateMethod.a;
/**
 * 模板方法模式：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。 模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤 
 * 优点：
 * 		代码复用最大化 算法存在一个地方，
 * 		容易修改 
 * 		由算法类主导一切，拥有算法且保护算法
 * 		方便扩展 
 * 		算法类专注算法本身，
 * 		而由子类提供完整的实现
 *好莱坞原则：别调用我们，我们会调用你。允许底层组件挂钩到系统上，但是由高层组件决定什么时候和怎么使用这些底层组件
 *工厂方法是模板方法的一种特殊版本
 */
public class Main {
	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		coffee.prepareRecipe();
		tea.prepareRecipe();
	}
}
