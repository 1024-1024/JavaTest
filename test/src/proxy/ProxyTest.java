package proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
		BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
		BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(),
				bpimpl.getClass().getInterfaces(), handler);
		bp.processBusiness();
	}
}
