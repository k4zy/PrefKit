package com.github.kazy1991.prefkit;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.kazy1991.prefkit.annotation.PrefKey;
import com.github.kazy1991.prefkit.annotation.PrefSchema;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ServiceMethod {

    private SharedPreferences sharedPreferences;

    private Method method;

    ServiceMethod(Context context, Method method) {
        String schemaName = method.getDeclaringClass().getAnnotation(PrefSchema.class).value();
        this.sharedPreferences = context.getSharedPreferences(schemaName, Context.MODE_PRIVATE);
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

    private void putBoolean(boolean value) {
        sharedPreferences.edit().putBoolean(prefKey(), value).apply();
    }

    private void putInt(int value) {
        sharedPreferences.edit().putInt(prefKey(), value).apply();
    }

    private void putString(String value) {
        sharedPreferences.edit().putString(prefKey(), value).apply();
    }

    private void putLong(long value) {
        sharedPreferences.edit().putLong(prefKey(), value).apply();
    }

    private void putFloat(float value) {
        sharedPreferences.edit().putFloat(prefKey(), value).apply();
    }

    private void put(Object[] args) {
        Object value = args[0];
        if (isMatched(value.getClass(), String.class)) {
            putString((String) value);
        } else if (isMatched(value.getClass(), Integer.class, int.class)) {
            putInt((int) value);
        } else if (isMatched(value.getClass(), Long.class, long.class)) {
            putLong((long) value);
        } else if (isMatched(value.getClass(), Float.class, float.class)) {
            putFloat((float) value);
        } else if (isMatched(value.getClass(), Boolean.class, boolean.class)) {
            putBoolean((boolean) value);
        } else {
            throw new IllegalStateException("Unknown type");
        }
    }

    private String getString(String defaultValue) {
        return sharedPreferences.getString(prefKey(), defaultValue);
    }

    private int getInt(int defaultValue) {
        return sharedPreferences.getInt(prefKey(), defaultValue);
    }

    private long getLong(long defaultValue) {
        return sharedPreferences.getLong(prefKey(), defaultValue);
    }

    private float getFloat(float defaultValue) {
        return sharedPreferences.getFloat(prefKey(), defaultValue);
    }

    private boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    private Object get(Object[] args) {
        Object defaultValue = args[0];

        if (isMatched(returnType(), String.class)) {
            return getString((String) defaultValue);
        } else if (isMatched(returnType(), Integer.class, int.class)) {
            return getInt((int) defaultValue);
        } else if (isMatched(returnType(), Long.class, long.class)) {
            return getLong((long) defaultValue);
        } else if (isMatched(returnType(), Float.class, float.class)) {
            return getFloat((float) defaultValue);
        } else if (isMatched(returnType(), Boolean.class, boolean.class)) {
            return getBoolean(prefKey(), (boolean) defaultValue);
        } else {
            throw new IllegalStateException("Unknown type");
        }
    }

    private boolean isMatched(Type type, Class<?>... classes) {
        return Arrays.asList(classes).contains(type);
    }

    private String prefKey() {
        return method.getAnnotation(PrefKey.class).value();
    }

    private Type returnType() {
        return method.getGenericReturnType();
    }
}
