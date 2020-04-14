package BehavioralPattern.ChainOfResponsibility;

public class ConcreteHandler extends Handler {
    @Override
    public void handlerRequest() {
        if (getHandler() != null) {
            System.out.println("进入下一个拦截请求");
            getHandler().handlerRequest();
        }else{
            System.out.println("放过");
        }
    }
}
