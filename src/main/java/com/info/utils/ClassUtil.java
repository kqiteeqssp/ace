package com.info.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shisp
 * @Date 2018/11/26 18:45
 */
public class ClassUtil {
    public static Map<String, String> setConditionMap(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        if (obj == null) {
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (getValueByFieldName(fieldName, obj) != null) {
                map.put(fieldName, (String) getValueByFieldName(fieldName, obj));
            }
        }

        return map;

    }

    /**
     * 根据属性名获取该类此属性的值
     *
     * @param fieldName
     * @param object
     * @return
     */
    private static String getValueByFieldName(String fieldName, Object object) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getter, new Class[]{});
            String value =  method.invoke(object, new Object[]{}).toString();
            return value;
        } catch (Exception e) {
            return null;
        }

    }
}
