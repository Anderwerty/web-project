package com.web.project.injector;

import com.web.project.service.TimeService;
import com.web.project.service.TimeServiceImpl;
import com.web.project.service.TimeServiceImpl2;

import java.util.HashMap;
import java.util.Map;

public class Injector {

    private static Map<String, Bean> classToInstance = new HashMap<>();

    static {
        classToInstance.put("timeServiceA", new Bean(TimeService.class, new TimeServiceImpl("url")));
        classToInstance.put("timeServiceB", new Bean(TimeService.class, new TimeServiceImpl2()));
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> tClass) {
        return (T) classToInstance.get(beanName).instance;
    }
}

class Bean {
    Class aClass;
    Object instance;

    public Bean(Class aClass, Object instance) {
        this.aClass = aClass;
        this.instance = instance;
    }
}
