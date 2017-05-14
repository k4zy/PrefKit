package com.github.kazy1991.prefkit;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.kazy1991.prefkit.annotation.PrefKey;
import com.github.kazy1991.prefkit.annotation.PrefSchema;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ServiceMethod {

    private Method method;

    private PreferenceHelper helper;

    public static final List<Locale> SUPPORT_LANG = Arrays.asList(Locale.JAPANESE, Locale.ENGLISH);

    ServiceMethod(Context context, Method method) {
        String schemaName = method.getDeclaringClass().getAnnotation(PrefSchema.class).value();
        SharedPreferences pref = context.getSharedPreferences(schemaName, Context.MODE_PRIVATE);
        String key = method.getAnnotation(PrefKey.class).value();
        this.helper = new PreferenceHelper(pref, key);
        this.method = method;
    }

    Object exec(Object[] args) {
        if (isMatched(returnType(), void.class, Void.class)) {
            put(args);
            return null;
        } else {
            return get(args);
        }
    }

    private void put(Object[] args) {
        Object value = args[0];
        if (isMatched(value.getClass(), String.class)) {
            helper.putString((String) value);
        } else if (isMatched(value.getClass(), Integer.class, int.class)) {
            helper.putInt((int) value);
        } else if (isMatched(value.getClass(), Long.class, long.class)) {
            helper.putLong((long) value);
        } else if (isMatched(value.getClass(), Float.class, float.class)) {
            helper.putFloat((float) value);
        } else if (isMatched(value.getClass(), Boolean.class, boolean.class)) {
            helper.putBoolean((boolean) value);
        } else {
            throw new IllegalStateException("Unknown type");
        }
    }

    private Object get(Object[] args) {
        Object defaultValue = args[0];
        if (isMatched(returnType(), String.class)) {
            return helper.getString((String) defaultValue);
        } else if (isMatched(returnType(), Integer.class, int.class)) {
            return helper.getInt((int) defaultValue);
        } else if (isMatched(returnType(), Long.class, long.class)) {
            return helper.getLong((long) defaultValue);
        } else if (isMatched(returnType(), Float.class, float.class)) {
            return helper.getFloat((float) defaultValue);
        } else if (isMatched(returnType(), Boolean.class, boolean.class)) {
            return helper.getBoolean((boolean) defaultValue);
        } else {
            throw new IllegalStateException("Unknown type");
        }
    }

    private boolean isMatched(Type type, Class<?>... classes) {
        return Arrays.asList(classes).contains(type);
    }

    private Type returnType() {
        return method.getGenericReturnType();
    }
}
