package com.zyf.busilog.operlog.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BusiLogUtils {

    /**
     * 类名
     */
    public static final String CLASS_NAME = "className";

    /**
     * 对象数据
     */
    public static final String BEAN_DATA = "beanData";

    /**
     * 反射获取对象数据
     *
     * @param className 类名
     * @param jsonData  json数据
     * @return 返回数据的类名和对象数据
     */
    public static Map<String, Object> getBeanData(String className, String jsonData) {
        Class<?> clazz = null;
        Object beanData = null;
        try {
            clazz = Class.forName(className);
            beanData = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果无法反射获取类型，则直接获得json串
        if (null == clazz || beanData == null) {
            beanData = jsonData;
        } else {
            beanData = JSONObject.parseObject(jsonData, clazz);
        }
        Map<String, Object> result = new HashMap<>();
        result.put(CLASS_NAME, beanData.getClass().getName());
        result.put(BEAN_DATA, beanData);
        return result;
    }

    /**
     * 对象转JSON字符串
     *
     * @param obj
     * @return
     */
    public static String objToJsonStr(Object obj) {
        return null == obj ? "" : (obj instanceof String ? (String) obj : JSONObject.toJSONString(obj));
    }
}
