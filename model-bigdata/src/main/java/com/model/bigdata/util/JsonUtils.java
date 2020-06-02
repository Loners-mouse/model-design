package com.model.bigdata.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

    /**
     * 将json转成对象
     *
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String value, Class<T> clazz) {
        if (value == null || value.isEmpty() || clazz == null) {
            return null;
        }
        try {
            return JSONObject.parseObject(value, clazz);
        } catch (Exception e) {
            System.out.println("e=" + e.getMessage());
        }
        return null;
    }

    /**
     * 将对象转成json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return JSONObject.toJSONString(object);
        } catch (Exception e) {

        }
        return null;
    }
}
