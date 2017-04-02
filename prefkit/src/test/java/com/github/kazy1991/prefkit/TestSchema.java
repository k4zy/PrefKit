package com.github.kazy1991.prefkit;

import com.github.kazy1991.prefkit.annotation.PrefKey;
import com.github.kazy1991.prefkit.annotation.PrefSchema;

@PrefSchema("TestSchema")
interface TestSchema {

    String stringKey = "stringKey";
    String integerKey = "integerKey";
    String longKey = "longKey";
    String floatKey = "floatKey";
    String booleanKey = "booleanKey";

    @PrefKey(stringKey)
    void putStringValue(String value);

    @PrefKey(stringKey)
    String getStringValue(String defaultValue);

    @PrefKey(integerKey)
    void putIntegerValue(int value);

    @PrefKey(integerKey)
    int getIntegerValue(int defaultValue);

    @PrefKey(longKey)
    void putLongValue(long value);

    @PrefKey(longKey)
    long getLongValue(long defaultValue);

    @PrefKey(floatKey)
    void putFloatValue(float value);

    @PrefKey(floatKey)
    float getFloatValue(float defaultValue);

    @PrefKey(booleanKey)
    void putBooleanValue(boolean value);

    @PrefKey(booleanKey)
    boolean getBooleanValue(boolean defaultValue);

}
