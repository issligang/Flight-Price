/**
 * 代理类和被代理类共同实现的接口
 */
interface IService {

    void service();
}


/**
 * 被代理类
 */
class Service implements IService{

    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}

/**
 * 代理类
 */
class ProxyService implements IService{
    /**
     * 持有被代理对象的引用
     */
    private IService service;

    /**
     * 默认代理Service类
     */
    public ProxyService() {
        this.service = new Service();
    }

    /**
     * 也可以代理实现相同接口的其他类
     * @param service
     */
    public ProxyService(IService service) {
        this.service = service;
    }

    @Override
    public void service() {
        System.out.println("开始执行service()方法");
        service.service();
        System.out.println("service()方法执行完毕");
    }
}


//测试类
public class TestTread {

    public static void main(String[] args) {
        IService service = new Service();
        //传入被代理类的对象
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
    }
}
