package com.github.kazy1991.prefkit;


import android.content.SharedPreferences;

public class PreferenceHelper {

    private SharedPreferences sharedPreferences;
    
    private String key;

    public PreferenceHelper(SharedPreferences sharedPreferences, String key) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
    }

    public void putBoolean(boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void putInt(int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public void putString(String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void putLong(long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public void putFloat(float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public String getString(String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public int getInt(int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public long getLong(long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public float getFloat(float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public boolean getBoolean(boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }



}
