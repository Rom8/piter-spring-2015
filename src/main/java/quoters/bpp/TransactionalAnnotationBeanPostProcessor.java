package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import quoters.annotations.Transactional;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Jeka on 14/10/2015.
 */
@Component
public class TransactionalAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Transactional.class)) {
            if (beanClass.getInterfaces().length == 0) {
                return Enhancer.create(beanClass, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        System.out.println("***********Transaction opened**********");
                        Object retVal = method.invoke(bean, args);
                        System.out.println("***********Transaction commited**********");
                        return retVal;
                    }
                });
            }
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("***********Transaction opened**********");
                    Object retVal = method.invoke(bean, args);
                    System.out.println("***********Transaction commited**********");
                    return retVal;
                }
            });
        }
        return bean;
    }
}








