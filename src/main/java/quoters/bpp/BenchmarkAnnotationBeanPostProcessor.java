package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import quoters.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Jeka on 14/10/2015.
 */
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Method originalBeanClassMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());
                        if (originalBeanClassMethod.isAnnotationPresent(Benchmark.class)) {
                            System.out.println("**********BENCHMARK************");
                            long before = System.nanoTime();
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            System.out.println("Method: "+method.getName()+" was working for "+(after-before));
                            System.out.println("**********BENCHMARK************");
                            return retVal;
                        }else {
                            return method.invoke(bean, args);

                        }
                    }
                });
            }
        }


        return bean;
    }
}











