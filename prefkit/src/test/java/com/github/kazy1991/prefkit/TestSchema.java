package com.github.kazy1991.prefkit;

import com.github.kazy1991.prefkit.annotation.PrefKey;
import com.github.kazy1991.prefkit.annotation.PrefSchema;

@PrefSchema("TestSchema")
interface TestSchema {

    @PrefKey("sampleKey")
    void setSampleValue(boolean value);

    @PrefKey("sampleKey")
    boolean getSampleValue(boolean defaultValue);
}
