package quoters.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * Created by Jeka on 15/10/2015.
 */
public class WarningBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String destroyMethodName = beanDefinition.getDestroyMethodName();
            if (destroyMethodName != null && beanDefinition.isPrototype()) {
                System.err.println("WARNING: bean with scope 'prototype' cannot have destroy method - bean definition name:" +
                name + ", destroy method name: " + destroyMethodName);
            }
        }
    }
}










