package com.aop.log;

import com.aop.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/11/23
 **/
@Aspect
@Component
public class LogAspect {
    private static final BlockingQueue<User> BLOCKING_QUEUE = new LinkedBlockingDeque<>();
    static {
        new Thread(new LogConsumer(BLOCKING_QUEUE)).start();
    }

    @Pointcut("@annotation(com.aop.log.HelloLog)")
    public void helloPointCut() {
    }


    @Before(value = "helloPointCut() && @annotation(helloLog)")
    public void testAspect(JoinPoint jp,HelloLog helloLog) throws IntrospectionException {
        Object[] args = jp.getArgs();
        Arrays.stream(args).forEach(x->{
            Arrays.stream(x.getClass().getDeclaredFields()).forEach(y->{
                if(y.getAnnotation(LogParam1.class) != null){
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(y.getName(), x.getClass());
                        String s = propertyDescriptor.getReadMethod().invoke(x).toString();

                        System.out.println("我终于拿到参数了"+s);
                    } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
        System.out.println(helloLog.desc());
        System.out.println("------------------");
    }
}
