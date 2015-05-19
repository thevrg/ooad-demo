package com.epam.edu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.transaction.Transactional;

/**
 *
 * @author tmp
 */
public class ProxyFactory {

    public <T> T createPerformanceMeasurerProxy(final T original, Class<T> type) {
        T proxy;
        proxy = (T) Proxy.newProxyInstance(
                ProxyDemo.class.getClassLoader(),
                new Class[]{type},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Transactional transactional = method.getAnnotation(Transactional.class);

                        if (transactional != null) {
                            System.out.println("Transactional method called: " + method);
                        } else {
                            System.out.println("Method called: " + method);
                        }
                        Throwable originalException = null;
                        long start = System.nanoTime();

                        try {
                            return method.invoke(originalException, args);
                        } catch (InvocationTargetException ex) {
                            originalException = ex.getCause();
                            throw originalException;
                        } finally {
                            long end = System.nanoTime();
                            final long duration = end - start;
                            if (originalException != null) {
                                System.out.println("Method call finished with an exception in " + duration + " ns");
                            } else {
                                System.out.println("Method call finished normally in " + duration + " ns");
                            }
                        }
                    }
                }
        );
        return proxy;
    }
}
