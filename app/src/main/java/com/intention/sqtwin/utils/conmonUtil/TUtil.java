package com.intention.sqtwin.utils.conmonUtil;

import java.lang.reflect.ParameterizedType;

import rx.functions.Func1;


/**
 * 类转换初始化
 */
public class TUtil {

    public static <T> T getT(android.content.ComponentCallbacks o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getTRx(Func1 o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

