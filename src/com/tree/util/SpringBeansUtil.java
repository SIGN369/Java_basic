package com.tree.util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeansUtil implements ApplicationContextAware{
	protected static final Logger log = LoggerFactory.getLogger(SpringBeansUtil.class);
	
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringBeansUtil.applicationContext == null) {
            SpringBeansUtil.applicationContext = applicationContext;
        }
        
      
        log.info("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringBeansUtil.applicationContext+"========");

    }
    //获取applicationContext
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public  Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public  <T> T getBean(Class<T> clazz){
    	init(clazz);
        T t = getApplicationContext().getBean(clazz);
    	Class<? extends Object> class1 = t.getClass();
		Class<?> superclass = class1.getSuperclass();
		try {
		T t2 = (T) class1.newInstance();
		Field jdbcTemplate=superclass.getDeclaredField("jdbcTemplate");
		jdbcTemplate.setAccessible(true);
        Field DABASE=superclass.getDeclaredField("DABASE");
        DABASE.setAccessible(true);
        Field __this_table_name=superclass.getDeclaredField("__this_table_name");
        __this_table_name.setAccessible(true);
        Class<?> superclass2 = t2.getClass().getSuperclass();
        
        Field jdbcTemplate2=superclass2.getDeclaredField("jdbcTemplate");
    	jdbcTemplate2.setAccessible(true);
        Field DABASE2=superclass2.getDeclaredField("DABASE");
        DABASE2.setAccessible(true);
        Field __this_table_name2=superclass2.getDeclaredField("__this_table_name");
        __this_table_name2.setAccessible(true);
        jdbcTemplate2.set(t2, jdbcTemplate.get(t));
        DABASE2.set(t2, DABASE.get(t));
        __this_table_name2.set(t2, __this_table_name.get(t));
        return t2;
		} catch (Exception e) {
			e.printStackTrace();
			return t;
		}
			
    }

    //通过name,以及Clazz返回指定的Bean
    public  <T> T getBean(String name,Class<T> clazz){
    	init(clazz);
        return getApplicationContext().getBean(name, clazz);
    }
    public <T> void init(Class<T> clazz) {
    	T t = applicationContext.getBean(clazz);
		Class<? extends Object> class1 = t.getClass();
		try {
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			String name = field.getName();
			if("serialVersionUID".equals(name)) {
				continue;
			}
			if("DABASE".equals(name)) {
				continue;
			}
			if("__this_table_name".equals(name)) {
				continue;
			}
			if("jdbcTemplate".equals(name)) {
				continue;
			}
			String tp = field.getType().getName();
			if(tp.equals("java.lang.String")) {
				field.set(t, null);
			}
			if(tp.equals("java.lang.Integer")) {
				field.set(t, null);
			}
			if(tp.equals("java.lang.Double")) {
				field.set(t, null);
			}
			if(tp.equals("java.lang.Long")) {
				field.set(t, null);
			}
			if(tp.equals("java.sql.Timestamp")) {
				field.set(t, null);
			}
			if(tp.equals("java.sql.Date")) {
				field.set(t, null);
			}
			if(tp.equals("int")) {
				field.set(t, 0);
			}
			if(tp.equals("double")) {
				field.set(t, 0D);
			}
			if(tp.equals("long")) {
				field.set(t, 0L);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
}

