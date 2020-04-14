package BehavioralPattern.L_State.a;

public class GumballMachine {
	// 存储糖果机4状态，糖果售空，没有25分(糖果25/1个)，有25分，出售
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QURATER = 2;
	final static int SOLD = 3;

	// 跟踪当前状态，默认没糖果
	int state = SOLD_OUT;
	// 追踪机器糖果数目
	int count = 0;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0)
			state = NO_QUARTER;
	}

	public void insertQuarter() {
		if (state == HAS_QURATER) {
			System.out.println("不能再投入25分");
		} else if (state == NO_QUARTER) {
			state = HAS_QURATER;
			System.out.println("你投入了25分");
		} else if (state == SOLD_OUT) {
			System.out.println("糖果售空，不能插入25分");
		} else if (state == SOLD) {
			System.out.println("请等待");
		}

	}

	public void ejectQuarter() {
		if (state == HAS_QURATER) {
			System.out.println("退回25分");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			System.out.println("没有钱，无法退回");
		} else if (state == SOLD_OUT) {// 糖果售空，无法投入钱，也就无法退出钱
			System.out.println("无法退回");
		} else if (state == SOLD) {// 已经出售糖果，无法退回钱
			System.out.println("无法退回");
		}
	}

	public void turnCrank() {
		if (state == SOLD) {
			System.out.println("别想骗机器拿2次糖果");
		} else if (state == NO_QUARTER) {
			System.out.println("请先投入25分");
		} else if (state == SOLD_OUT) {
			System.out.println("售空，无法给予糖果");
		} else if (state == HAS_QURATER) {
			System.out.println("已售出");
			state = SOLD;
			dispense();
		}
	}

	public void dispense() {
		if (state == SOLD) {
			System.out.println("正在售出糖果");
			count--;
			if (count == 0) {
				System.out.println("糖果已经售完");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		}// 下面这些都不应该发生
		else if (state == NO_QUARTER) {
			System.out.println("需要投入钱");
		} else if (state == SOLD_OUT) {
			System.out.println("没糖果出售");
		} else if (state == HAS_QURATER) {
			System.out.println("没有糖果出售");
		}
	}

	@Override
	public String toString() {
		return "GumballMachine [state=" + state + ", count=" + count + "]";
	}

	
}
