package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import quoters.annotations.Benchmark;
import quoters.mBeans.BenchmarkController;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 14/10/2015.
 */
@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> beanName2OriginalClass = new HashMap<>();
    private BenchmarkController benchmarkController = new BenchmarkController();

    public BenchmarkAnnotationBeanPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(benchmarkController, new ObjectName("piterMBeans", "name", "benchmark"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                beanName2OriginalClass.put(beanName, beanClass);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanName2OriginalClass.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalBeanClassMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
                    if (originalBeanClassMethod.isAnnotationPresent(Benchmark.class)&& benchmarkController.isEnabled()) {
                        System.out.println("**********BENCHMARK************");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println("Method: " + method.getName() + " was working for " + (after - before));
                        System.out.println("**********BENCHMARK************");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);

                    }
                }
            });
        }


        return bean;
    }
}











