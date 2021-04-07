package com.shop.autowire;


import com.shop.common.annotation.Component;
import com.shop.common.annotation.Repository;
import com.shop.common.annotation.Service;
import com.shop.repository.RoleRepository;
import com.shop.repository.UserRepository;
import com.shop.service.RoleService;
import com.shop.service.UserService;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {
    public static Map<String, Object> beans;

    static {
        synchronized (BeanFactory.class) {
            beans = new HashMap<>();
            createBean();
        }
    }

    public static synchronized void createBean() {
        Reflections reflection = new Reflections("com.shop");
        Set<? extends Class> classes = reflection.getTypesAnnotatedWith(Component.class);

        classes.forEach(s -> {
            try {
                if (!s.getTypeName().equals(Service.class.getTypeName()) && !s.getTypeName().equals(Repository.class.getTypeName())) {
                    String name = s.getSimpleName().substring(0, 1).toLowerCase() + s.getSimpleName().substring(1, s.getSimpleName().lastIndexOf("Impl"));
                    beans.put(name, s.newInstance());
                }
            } catch(InstantiationException | IllegalAccessException e){
                    e.printStackTrace();
            }
        });
    }

    public static Map<String, Object> getBeans() {
        return beans;
    }
}

