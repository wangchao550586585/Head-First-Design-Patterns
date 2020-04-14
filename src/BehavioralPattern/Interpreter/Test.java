package BehavioralPattern.Interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * 解释器模式
 * 逆波兰表达式
 * 定义：给定一种语言，定义他的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中句子。
 *
 * 解释器模式的结构
 抽象解释器：声明一个所有具体表达式都要实现的抽象接口（或者抽象类），接口中主要是一个interpret()方法，称为解释操作。具体解释任务由它的各个实现类来完成，
 具体的解释器分别由终结符解释器TerminalExpression和非终结符解释器NonterminalExpression完成。
 终结符表达式：实现与文法中的元素相关联的解释操作，通常一个解释器模式中只有一个终结符表达式，但有多个实例，对应不同的终结符。终结符一半是文法中的运算单元，比如有一个简单的公式R=R1+R2，
 在里面R1和R2就是终结符，对应的解析R1和R2的解释器就是终结符表达式。
 非终结符表达式：文法中的每条规则对应于一个非终结符表达式，非终结符表达式一般是文法中的运算符或者其他关键字，比如公式R=R1+R2中，+就是非终结符，解析+的解释器就是一个非终结符表达式。
 非终结符表达式根据逻辑的复杂程度而增加，原则上每个文法规则都对应一个非终结符表达式。
 环境角色：这个角色的任务一般是用来存放文法中各个终结符所对应的具体值，比如R=R1+R2，我们给R1赋值100，给R2赋值200。这些信息需要存放到环境角色中，很多情况下我们使用Map来充当环境角色就足够了。

 解释器模式的优缺点
     解释器是一个简单的语法分析工具，它最显著的优点就是扩展性，修改语法规则只需要修改相应的非终结符就可以了，若扩展语法，只需要增加非终结符类就可以了。
     但是，解释器模式会引起类的膨胀，每个语法都需要产生一个非终结符表达式，语法规则比较复杂时，就可能产生大量的类文件，为维护带来非常多的麻烦。
     同时，由于采用递归调用方法，每个非终结符表达式只关心与自己相关的表达式，每个表达式需要知道最终的结果，必须通过递归方式，无论是面向对象的语言还是面向过程的语言，
     递归都是一个不推荐的方式。由于使用了大量的循环和递归，效率是一个不容忽视的问题。特别是用于解释一个解析复杂、冗长的语法时，效率是难以忍受的。

 解释器模式的适用场景
 在以下情况下可以使用解释器模式：
 有一个简单的语法规则，比如一个sql语句，如果我们需要根据sql语句进行rm转换，就可以使用解释器模式来对语句进行解释。
 一些重复发生的问题，比如加减乘除四则运算，但是公式每次都不同，有时是a+b-c*d，有时是a*b+c-d，等等等等个，公式千变万化，但是都是由加减乘除四个非终结符来连接的，这时我们就可以使用解释器模式。
 */
class Context {
    private String input;
    private int output;

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}

abstract class AbstractExpression {
    public abstract void interpret(Context context);
}

class PlusExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        int output = Integer.parseInt(context.getInput()) + 1;
        context.setOutput(output);
        context.setInput(String.valueOf(output));

    }
}

class MinusExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        int output = Integer.parseInt(context.getInput()) - 1;
        context.setOutput(output);
        context.setInput(String.valueOf(output));
    }
}


public class Test {
    public static void main(String[] args) {
        Context context = new Context("100");

        List<AbstractExpression> expressions = new ArrayList<>();
        expressions.add(new MinusExpression());
        expressions.add(new MinusExpression());
        expressions.add(new PlusExpression());

        expressions.forEach(expression -> {
            expression.interpret(context);
            System.out.println(context.getOutput());
        });
    }
}
