package StructuralPattern.H_Facade;

/**
 * 外观模式：提供一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用
 * 		简化接口时，依然将系统完整的功能暴露出来，供给需要的人用。将客户从组件的子系统中解耦
 * 		如果变得复杂，有太多的朋友牵涉其中，可以增加更多的外观，将子系统分成几个层次
 * 设计原则：最少知识原则，只和你的密友谈话(减少对象之间交互，只留下几个"密友")
 * 		要求：在该对象的方法内，只应该调用属于如下范围的方法
 * 			如果某对象是调用其他方法返回结果，不要调用该对象的方法
 * 			1：该对象本身
 * 			2：被当做方法的参数所传递的对象
 * 			3：此方法所创建或实例化的任何对象
 * 			4：对象的任何组件(被实例引用的任何对象，想象成has-a关系)
 * 		缺点：导致更多包装类被制造出来，已处理和其他组件的沟通
 * 
 *
 */
public class Main {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		TheaterLights lights = new TheaterLights();
		Screen screen = new Screen();
		PopcornPopper popper = new PopcornPopper();
		
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp, tuner,
				dvd, cd, projector, lights, screen, popper);
		homeTheaterFacade.watchMovie("看电影");
		homeTheaterFacade.endMovie();

	}

}
