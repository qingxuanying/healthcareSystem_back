package com.example.demo.utils;

import com.google.gson.Gson;

public class JsonUtil {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static Object toObject(String json, Class<? extends Object> type) {
        return new Gson().fromJson(json,type);
    }


}
