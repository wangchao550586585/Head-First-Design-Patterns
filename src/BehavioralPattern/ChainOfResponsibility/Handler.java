package BehavioralPattern.ChainOfResponsibility;

public abstract class Handler {
    protected Handler handler;

    //示意处理方法的请求，可以设置值
    public abstract void handlerRequest();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
